package chapterIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestIO {

    @Test
    public void testCopyFile(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            File src = new File("E:"+File.separator+"GIAS.log.2018-08-02.16.log");
            if(!src.exists()){
                src.createNewFile();
            }
            File dest = new File("E:"+File.separator+"GIAS.log.2018-08-02.16.txt");
            if(!dest.exists()){
                dest.createNewFile();
            }
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);
            byte[] bytes = new byte[521];
            int length = -1;
            while( (length=fileInputStream.read(bytes))!=-1 ){
                fileOutputStream.write(bytes);
                stringBuffer.append(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println(stringBuffer);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
