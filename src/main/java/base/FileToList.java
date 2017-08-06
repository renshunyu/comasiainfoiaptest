package base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/4/23.
 */
public class FileToList {
    Logger log = Logger.getLogger("FileToList.class");
    public List<String> readFromFile(File src) {
        try {
            FileInputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            BufferedReader bufferedReader = new BufferedReader(isr);
            List ls = new ArrayList();
            String content;
            while((content = bufferedReader.readLine() )!=null){
                log.debug(content.toString());
                ls.add(content.toString());
            }
            bufferedReader.close();
            isr.close();
            fis.close();
            return ls;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }
}
