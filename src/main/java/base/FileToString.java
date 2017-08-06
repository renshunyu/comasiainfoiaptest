package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rensy
 *
 */
public class FileToString {
	public String readFromFile(File src) {
        try {
            FileInputStream fis = new FileInputStream(src);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            BufferedReader bufferedReader = new BufferedReader(isr);

            StringBuilder stringBuilder = new StringBuilder();
            String content;
            while((content = bufferedReader.readLine() )!=null){
                stringBuilder.append(content);
            }

            bufferedReader.close();
            isr.close();
            fis.close();
            System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
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
