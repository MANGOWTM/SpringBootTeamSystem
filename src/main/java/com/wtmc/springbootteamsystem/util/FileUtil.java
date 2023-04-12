package com.wtmc.springbootteamsystem.util;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读写文件的操作
 */
public class FileUtil {
    /**
     * 读文件
     * @param filePath 读取的文件
     * @return 返回读取的内容
     */
    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try(FileReader fileReader = new FileReader(filePath)){
            while (true) {
                int ch = fileReader.read();
                if (ch == -1){
                    break;
                }
                result.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    /**
     * 写文件
     * @param filePath 要写入的文件
     * @param content 写入的内容
     */
    public static void writeFile(String filePath, String content) {
        try(FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            System.out.println("文件删除失败,请检查文件是否存在以及文件路径是否正确");
            return ;
        }
        //获取目录下子文件
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                //递归删除目录下的文件
                deleteFile(f);
            } else {
                //文件删除
                f.delete();
                //打印文件名
                System.out.println("文件名：" + f.getName());
            }
        }
        //文件夹删除
        file.delete();
        System.out.println("目录名：" + file.getName());
        return ;
    }
}


