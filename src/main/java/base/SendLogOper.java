/**
 * 
 */
package base;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.asiainfo.simulator.tcp.pool.SendPool;

/**
 * @author rensy
 *
 */
public class SendLogOper {
	Logger log = Logger.getLogger("SendLogOper.class");
	private static boolean hasStartup = false;
	public void initSendPool(HashMap<String, String> hm){
    	if (hasStartup)
    		return;
    	try{
    		SendPool.getInstance().init(hm);
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	SendPool.getInstance().startup();
    	hasStartup = true;
    }
    
    public void tcpSend(String sendLog){
    	try{
	        log.info("snedlog=" + sendLog);
	        SendPool.getInstance().putMessage(sendLog.getBytes("UTF-8"));
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void endSendPool(){
    	if (!(hasStartup))
    		return;
    	SendPool.getInstance().shutdown();
    	hasStartup = false;
    }
}
