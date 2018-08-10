package chapterFile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestFile {
    @Test
    public void testSeparator(){
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    /**
     * File Constructor
     *      1：File(File parent, String child)
     *          Creates a new File instance from a parent abstract pathname and a child pathname string.
     *      2：File(String pathname)
     *          Creates a new File instance by converting the given pathname string into an abstract pathname.
     *      3：File(String parent, String child)
     *          Creates a new File instance from a parent pathname string and a child pathname string.
     *      4：File(URI uri)
     *          Creates a new File instance by converting the given file: URI into an abstract pathname.
     */
    @Test
    public void testFile(){

        File file01 = new File("D:\\IO\\test.txt");
        System.out.println(file01);
        File file02 = new File("D:"+File.separator+"IO"+File.separator+"test.txt");
        System.out.println(file02);
        System.out.println(file01.equals(file02));

        File file03 = new File("D:");
        File file04 = new File(file03,"IO");
        System.out.println(file04);
        File file05 = new File("D:","IO\\test.txt");
        System.out.println(file05);
        System.out.println(file02.equals(file05));
    }

    @Test
    public void testFileMethod() throws IOException {
        //定义文件所在目录
        File dir = new File("D:"+File.separator+"IO");
        //定义文件
        File file = new File(dir,"test.txt");
        //文件目录存在或者是个目录
        if(!(dir.exists()||dir.isDirectory())){
            System.out.println("dir does not exist...");
            //如果不存在，创建目录，并创建文件
            dir.mkdirs();
            file.createNewFile();
        }
        //返回由此抽象路径名表示的文件或目录的名称。 这只是路径名称序列中的最后一个名字。
        // 如果路径名的名称序列为空，则返回空字符串。
        System.out.println(file.getName());
        //返回此抽象路径名的父的路径名字符串，如果此路径名未命名为父目录，则返回null。
        System.out.println(file.getParent());
        //将此抽象路径名转换为路径名字符串。
        // 结果字符串使用default name-separator character以名称顺序分隔名称。
        System.out.println(file.getPath());

        System.out.println(file.getAbsolutePath());
        System.out.println(file.lastModified());
        System.out.println(file.length());
    }

}
