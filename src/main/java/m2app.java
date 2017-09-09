import base.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/27.
 */
public class m2app {


    public static void main( String[] args ) throws InterruptedException, IOException {
        Logger log = Logger.getLogger(m2app.class);


        String session,cmd ,sesend;
        FileToString fs = new   FileToString();
        session = fs.readFromFile(new File("session.txt"));
        cmd = fs.readFromFile(new File("cmd.txt"));
        sesend = fs.readFromFile(new File("sesend.txt"));

        FileToList fl = new FileToList();
        List l = fl.readFromFile(new File("hiscmd.txt"));
        List acct = fl.readFromFile(new File("acct.txt"));
        List ips = fl.readFromFile(new File("ip.txt"));



        ClassPathXmlApplicationContext tt = new ClassPathXmlApplicationContext("spring-thread.xml");
        sendConfig sc = (sendConfig) tt.getBean("sendconf");
        //sendConfig sc = new sendConfig();
        SendLogOper slo = new SendLogOper();
        slo.initSendPool(sc.sendconf());

        ThreadPoolTaskExecutor pool  = (ThreadPoolTaskExecutor) tt.getBean("taskExecutor");
        log.info(pool.getActiveCount()+"ren");
        log.info(pool.getCorePoolSize()+"ren");
        log.info(pool.getKeepAliveSeconds()+"ren");
        log.info(pool.getMaxPoolSize()+"ren");

        my2runnable ra = new my2runnable();
        ra.setSession(session);
        ra.setCmd(cmd);
        ra.setSesend(sesend);
        ra.setL(l);
        ra.setSlo(slo);
        ra.setAcct(acct);
        ra.setIps(ips);
        //Future f = pool.submit(ra);


        int i =0;
        RunPremeter runconf = (RunPremeter) tt.getBean("runconf");
        log.info("同时运行的最大session数为：-----"+Integer.parseInt(runconf.getConf().getProperty("sessioNum"))+"-------");
        log.info("session间隔为：-----"+Integer.parseInt(runconf.getConf().getProperty("sessionStep"))+"-------");
        log.info("登录概率为：-----"+Integer.parseInt(runconf.getConf().getProperty("gaiLv").replaceAll("%",""))+"-------");
        while (true){
            log.info(pool.getActiveCount()+"   getActiveCountstart");

            if (pool.getActiveCount() < Integer.parseInt(runconf.getConf().getProperty("sessioNum"))){
                if ((int) (1+Math.random()*(100-1+1)) <= Integer.parseInt(runconf.getConf().getProperty("gaiLv").replaceAll("%",""))){
                    pool.submit(ra);
                    log.info("第"+ i++ +"个线程");
                }
            }
            log.info(pool.getActiveCount()+"   getActiveCountend");
            Thread.sleep(Integer.parseInt(runconf.getConf().getProperty("sessionStep")));
        }

    }
}
