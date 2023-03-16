package com.wtmc.springbootteamsystem.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommonUtil {
    public static int runCmd(String cmd,String stderrFile) {

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            if(stderrFile != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
