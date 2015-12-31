package com.example.sumedh.filewriter;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by sumedh on 12/31/15.
 */
public class Logger {

    public static boolean fileLogEnable = false;

    public static void LogV(String tag, String msg){
        Log.v(tag, msg);
        if(fileLogEnable){
            writeToFile(tag + "_v", msg);
        }
    }
    public static void LogD(String tag, String msg){
        Log.d(tag, msg);
        if(fileLogEnable){
            writeToFile(tag + "_d", msg);
        }
    }
    public static void LogI(String tag, String msg){
        Log.i(tag, msg);
        if(fileLogEnable){
            writeToFile(tag + "_i", msg);
        }
    }
    public static void LogE(String tag, String msg){
        Log.e(tag, msg);
        if(fileLogEnable){
            writeToFile(tag + "_e", msg);
        }
    }
    public static void LogW(String tag, String msg){
        Log.w(tag, msg);
        if(fileLogEnable){
            writeToFile(tag + "_w", msg);
        }
    }

    private static void writeToFile(String tag, String msg) {
        String timeLog = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        String fileContents = tag + ": time : " + timeLog +  ":" + msg + "\n";
        FileWriter out = null;
        try {
            out = new FileWriter(new File(Environment.getExternalStorageDirectory().getPath(), "outputlogs.txt"), true);
            out.append(fileContents);
            out.flush();
            out.close();
            out = null;
        } catch (IOException e) {
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
