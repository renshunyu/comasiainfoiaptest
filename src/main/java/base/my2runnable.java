package base;

import service.sendfun;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/4/27.
 */
public class my2runnable implements Runnable {
    Logger log = Logger.getLogger("my2runnable.class");
    String session;
    String cmd;
    String sesend;


    List l,acct,ips;
    SendLogOper slo ;

    public void setIps(List ips) {
        this.ips = ips;
    }

    public void setAcct(List acct) {
        this.acct = acct;
    }

    public void setSlo(SendLogOper slo) {
        this.slo = slo;
    }

    public void setL(List l) {
        this.l = l;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void setSesend(String sesend) {
        this.sesend = sesend;
    }


    public void run() {
        log.info("efrgsddfsdfsdf");
        sendfun sf = new sendfun();
        int arow = (int)(Math.random()*(acct.size()));
        String ac = (String) acct.get(arow);
        int iprow = (int)(Math.random()*(ips.size()));
        String ip = (String) ips.get(iprow);
        try {
            sf.doit(this.session,this.cmd,this.sesend,ac,ip,this.l,this.slo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("renshuuny");
    }
}
