/**
 * 
 */
package base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.log4j.Logger;

/**
 * @author rensy
 *
 */
public class StringDeal {
	Logger log = Logger.getLogger("StringDeal.class");
	UUID uuid = UUID.randomUUID();
	String s ;
	public StringDeal(){
		this.s =uuid.toString();
	}

	public String strdeal(String str){
		Date date = new Date();
	    SimpleDateFormat formater = new SimpleDateFormat();
	    formater.applyPattern("yyyy-MM-dd HH:mm:ss");
		String shijian = formater.format(date);
	    log.info(shijian);
		str = str.replaceAll("<OPERATE_TIME>.*?</OPERATE_TIME>", "<OPERATE_TIME>" + shijian + "</OPERATE_TIME>");
		str = str.replaceAll("<IDR_CREATION_TIME>.*?</IDR_CREATION_TIME>", "<IDR_CREATION_TIME>" + shijian + "</IDR_CREATION_TIME>");
		str = str.replaceAll("<SESSION_BEGIN_TIME>.*?</SESSION_BEGIN_TIME>", "<SESSION_BEGIN_TIME>"+shijian+"</SESSION_BEGIN_TIME>");
		str = str.replaceAll("<SESSION_END_TIME>.*?</SESSION_END_TIME>", "<SESSION_END_TIME>"+shijian+"</SESSION_END_TIME>");
		return str;
		
	}

	public String strdeal(String str,String acct){
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("yyyy-MM-dd HH:mm:ss");
		String shijian = formater.format(date);
		log.info(shijian+"开始");
		str = str.replaceAll("<MAIN_ACCOUNT_NAME>.*?</MAIN_ACCOUNT_NAME>", "<MAIN_ACCOUNT_NAME>" + acct + "</MAIN_ACCOUNT_NAME>");
		str = str.replaceAll("<OPERATE_TIME>.*?</OPERATE_TIME>", "<OPERATE_TIME>" + shijian + "</OPERATE_TIME>");
		str = str.replaceAll("<IDR_CREATION_TIME>.*?</IDR_CREATION_TIME>", "<IDR_CREATION_TIME>" + shijian + "</IDR_CREATION_TIME>");
		str = str.replaceAll("<SESSION_BEGIN_TIME>.*?</SESSION_BEGIN_TIME>", "<SESSION_BEGIN_TIME>"+shijian+"</SESSION_BEGIN_TIME>");
		str = str.replaceAll("<SESSION_END_TIME>.*?</SESSION_END_TIME>", "<SESSION_END_TIME>"+shijian+"</SESSION_END_TIME>");
		log.info(shijian+"结束");
		return str;

	}
	
	public String strdeal2(String str){
		str = str.replaceAll("<ROOT>","");
		str = str.replaceAll("</ROOT>","");
		str = str.replaceAll("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
		str = str.replaceAll("<\\?xml version=\"1\\.0\" encoding=\"UTF-8\"\\?>","");
		return str;
	}
	
	public String strdeal3(String str){
		str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<ROOT>" + str + "</ROOT>";
		return str;
	}
	public String strdeal4(String str){
		log.info(this.s);
		str = str.replaceAll("<SESSION_ID>.*?</SESSION_ID>", "<SESSION_ID>" + this.s + "</SESSION_ID>");
		str = str.replaceAll("<DETAILS_LOG_ID>.*?</DETAILS_LOG_ID>", "<DETAILS_LOG_ID>" + UUID.randomUUID().toString() + "</DETAILS_LOG_ID>");

		return str;
	}
	public String strdeal5(String str,String cmd){

		str = str.replaceAll("<OPERATE_CONTENT>.*?</OPERATE_CONTENT>", "<OPERATE_CONTENT>" + cmd + "</OPERATE_CONTENT>");
		str = str.replaceAll("<OPERATE_CMD>.*?</OPERATE_CMD>", "<OPERATE_CMD>" + cmd.split(" ")[0] + "</OPERATE_CMD>");

		return str;
	}


}
