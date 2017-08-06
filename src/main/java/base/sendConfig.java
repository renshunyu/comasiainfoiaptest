/**
 * 
 */
package base;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author rensy
 *	加载的配置配置文件
 */
public class sendConfig {

	private Properties p = new Properties();

	public void setP(Properties p) {
		this.p = p;
	}

	private HashMap<String, String> ha = new HashMap<String, String>();
	
/*	public sendConfig() throws FileNotFoundException, IOException{
		FileInputStream conf = new FileInputStream(new File("uac.properties"));
		this.p.load(conf);
		conf.close();

	}*/
	
	public HashMap<String, String> sendconf() {


        ha.put("gather-ip-0", p.getProperty("gather-ip-0"));
        ha.put("gather-port-0", p.getProperty("gather-port-0"));
        ha.put("backup-directory", p.getProperty("backup-directory"));
        ha.put("pool-max-capacity", p.getProperty("pool-max-capacity"));
        ha.put("pool-max-send-workers", p.getProperty("pool-max-send-workers"));
        ha.put("record-directory", p.getProperty("record-directory"));
		return ha;
		
	}
	
}
