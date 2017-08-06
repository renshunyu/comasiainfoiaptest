import base.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/4/23.
 */
public class mapp {

    public static void main( String[] args ) throws InterruptedException, IOException {


        Logger log = Logger.getLogger(mapp.class);
        log.isEnabledFor(Level.DEBUG);
        log.debug("renshunyu");
        log.error(log.isDebugEnabled());
        log.info("sdfasdfasdf");
        log.warn("sdfsdfsdfgsdg");
        log.trace("fsdfgsdfgsf");
        log.fatal("asdfsdf");
        log.debug("renshunyu");
        log.debug("renshunyu");
        log.debug("renshunyu");
        log.debug("renshunyu");

        //-----------------------------------------
/*
        UUID uuid = UUID.randomUUID();

        System.out.print(UUID.randomUUID().toString()+"\n");
        System.out.print(UUID.randomUUID().toString()+"\n");
        System.out.print(UUID.randomUUID().toString()+"\n");
        System.out.print(UUID.randomUUID().toString()+"\n");
        System.out.print(UUID.randomUUID().toString()+"\n");
        System.out.print(UUID.randomUUID().toString()+"\n");


        Thread.sleep(1000000);
*/





        //-----------------------------------------


        log.debug("renshunyu");
        ClassPathXmlApplicationContext tt = new ClassPathXmlApplicationContext("spring-thread.xml");
        ThreadPoolTaskExecutor pool  = (ThreadPoolTaskExecutor) tt.getBean("taskExecutor");

        log.info(pool.getActiveCount()+"ren");
        log.info(pool.getCorePoolSize()+"ren");
        log.info(pool.getKeepAliveSeconds()+"ren");
        log.info(pool.getMaxPoolSize()+"ren");

        myrunnable ra = new myrunnable();
        //Future f = pool.submit(ra);
        /*pool.submit(ra);
        pool.submit(ra);
        pool.submit(ra);
        pool.submit(ra);
        System.out.print(pool.getActiveCount()+"ActiveCount"+"\n");

        Thread.sleep(1000000);*/

        int i =0;

        while (true){
            log.info( pool.getActiveCount()+"   getActiveCountstart");


            if (pool.getActiveCount() < 7){
                pool.submit(ra);
                log.info("第"+ i++ +"个线程");

            }
            log.info( pool.getActiveCount()+"   getActiveCountend");
            Thread.sleep(1000);
        }


/*        while (pool.getActiveCount() != 0){
            System.out.print(pool.getActiveCount()+"ren"+"\n");
            Thread.sleep(500);
        }
        pool.shutdown();*/







    }
}
