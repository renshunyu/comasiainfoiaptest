package base;


import service.sendfun;

import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/4/23.
 */
public class myrunnable implements Runnable{
    Logger log = Logger.getLogger("myrunnable.class");


    public void run() {
        log.info("efrgsddfsdfsdf");
        sendfun sf = new sendfun();
        try {
            sf.doit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("renshuuny");

    }
}
