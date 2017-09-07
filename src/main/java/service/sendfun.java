package service;

import base.*;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * Created by Administrator on 2017/4/23.
 */
public class sendfun {
    private Logger log = Logger.getLogger("sendfun.class");
    ClassPathXmlApplicationContext tt = new ClassPathXmlApplicationContext("spring-thread.xml");

    public void doit() throws IOException, InterruptedException {
        FileToString fs = new   FileToString();
        String session,cmd ,sesend;
        File df = new File(".");
        log.info("qwer");
        log.info(df.getAbsolutePath());
        log.info("asdf");
        session = fs.readFromFile(new File("session.txt"));
        cmd = fs.readFromFile(new File("cmd.txt"));
        sesend = fs.readFromFile(new File("sesend.txt"));
        FileToList fl = new FileToList();
        List l = fl.readFromFile(new File("hiscmd.txt"));
        int num = (int)(1+Math.random()*(20-1+1));
        int frow;

        List acct = fl.readFromFile(new File("acct.txt"));
        String ac = (String) acct.get((int)(Math.random()*(acct.size())));
        List ips = fl.readFromFile(new File("ip.txt"));
        String ip = (String) ips.get((int)(Math.random()*(ips.size())));
        log.info("登录主账号为："+ac);
        log.info("服务器ip为："+ip);



        log.info("session");
        log.info("cmd");
        log.info("sesend");
        SendLogOper slo = new SendLogOper();
        sendConfig sc = new sendConfig();
        slo.initSendPool(sc.sendconf());
        StringDeal sd = new StringDeal();
        slo.tcpSend(sd.strdeal4(sd.strdeal(session,ac,ip)));
        /*slo.endSendPool();*/
        Thread.sleep((long) (1+Math.random()*(3000-1+1)));
        for (int i=0 ;i<num ;i++){
            frow = (int)(Math.random()*(l.size()));
            log.info("frow"+frow);
            log.info("frow"+l.get(frow));
            //slo.tcpSend(sd.strdeal(l.get(frow).toString()));
            /*slo.initSendPool(sc.sendconf());*/
            slo.tcpSend(sd.strdeal5(sd.strdeal4(sd.strdeal(cmd,ac,ip)),l.get(frow).toString()));
            /*slo.endSendPool();*/
            log.info(i+"cmd");
            Thread.sleep((long) (1+Math.random()*(3000-1+1)));

        }
        /*slo.initSendPool(sc.sendconf());*/
        slo.tcpSend(sd.strdeal4(sd.strdeal(sesend,ac,ip)));
        slo.endSendPool();
        log.info("endSendPool");
    }

    public void doit(String session,String cmd,String sesend,List l,SendLogOper slo) throws IOException, InterruptedException {
        FileToString fs = new   FileToString();
        File df = new File(".");
        log.info("qwer");
        log.info(df.getAbsolutePath());
        log.info("asdf");
        FileToList fl = new FileToList();
        int num = (int)(1+Math.random()*(20-1+1));
        int frow;



        log.info("session");
        log.info("cmd");
        log.info("sesend");

        StringDeal sd = new StringDeal();
        slo.tcpSend(sd.strdeal4(sd.strdeal(session)));
        /*slo.endSendPool();*/
        Thread.sleep((long) (1+Math.random()*(3000-1+1)));
        RunPremeter runconf = (RunPremeter) tt.getBean("runconf");

        for (int i=0 ;i<num ;i++){
            frow = (int)(Math.random()*(l.size()));
            log.info("frow"+frow);
            log.info("frow"+l.get(frow));
            //slo.tcpSend(sd.strdeal(l.get(frow).toString()));
            /*slo.initSendPool(sc.sendconf());*/
            slo.tcpSend(sd.strdeal5(sd.strdeal4(sd.strdeal(cmd)),l.get(frow).toString()));
            /*slo.endSendPool();*/
            log.info(i+"cmd");
            Thread.sleep((long) (1+Math.random()*(Integer.parseInt(runconf.getConf().getProperty("cmdStep"))-1+1)));

        }
        /*slo.initSendPool(sc.sendconf());*/
        slo.tcpSend(sd.strdeal4(sd.strdeal(sesend)));
        log.info("endSendPool");
    }

    public void doit(String session,String cmd,String sesend,String ac,List l,SendLogOper slo) throws IOException, InterruptedException {
        FileToString fs = new   FileToString();
        File df = new File(".");
        log.info("qwer");
        log.info(df.getAbsolutePath());
        log.info("asdf");
        FileToList fl = new FileToList();
        int num = (int)(1+Math.random()*(20-1+1));
        int frow;



        log.info("session");
        log.info("cmd");
        log.info("sesend");

        StringDeal sd = new StringDeal();
        slo.tcpSend(sd.strdeal4(sd.strdeal(session,ac)));
        RunPremeter runconf = (RunPremeter) tt.getBean("runconf");
        /*slo.endSendPool();*/
        Thread.sleep((long) (1+Math.random()*(3000-1+1)));
        log.info("命令最大时间间隔为：-----"+Integer.parseInt(runconf.getConf().getProperty("cmdStep"))+"-------");
        for (int i=0 ;i<num ;i++){
            frow = (int)(Math.random()*(l.size()));
            log.info("frow"+frow);
            log.info("frow"+l.get(frow));
            //slo.tcpSend(sd.strdeal(l.get(frow).toString()));
            /*slo.initSendPool(sc.sendconf());*/
            log.info("登录主账号为：-----------" + ac );
            slo.tcpSend(sd.strdeal5(sd.strdeal4(sd.strdeal(cmd,ac)),l.get(frow).toString()));
            log.info("登录主账号为：-----------" + ac );
            /*slo.endSendPool();*/
            log.info(i+"cmd");
            Thread.sleep((long) (1+Math.random()*(Integer.parseInt(runconf.getConf().getProperty("cmdStep"))-1+1)));

        }
        /*slo.initSendPool(sc.sendconf());*/
        log.info("发送会话结束日志开始------");
        slo.tcpSend(sd.strdeal4(sd.strdeal(sesend,ac)));
        log.info("发送会话结束日志结束------");
        log.info("endSendPool");
    }
}
