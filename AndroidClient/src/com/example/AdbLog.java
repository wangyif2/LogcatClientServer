package com.example;

import android.os.Environment;
import android.util.Log;
import com.example.TimeStamp;

import java.io.*;
import java.util.Date;

public class AdbLog {
    private static TimeStamp timeStamp = new TimeStamp(new Date());
    private static String generateLogcatLogCommond = "logcat -d > /sdcard/IssueReport/log.txt";
    private static String generateSysDumpCommond = "dumpsys > /sdcard/IssueReport/sysdump.txt";
    public static String logLocation = null;

    public static String generateLogcatLog() throws InterruptedException {
        try {
            File issueReport = new File(Environment.getExternalStorageDirectory(), "IssueReport");
            if (!issueReport.exists())
                issueReport.mkdir();
            File logFile = new File(issueReport,"log.txt");
            logFile.createNewFile();

            Process process = Runtime.getRuntime().exec("/system/bin/sh -");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(generateLogcatLogCommond);

//            process.waitFor();
            logLocation = "/sdcard/IssueReport/log.txt";
            Log.d("Client", logLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logLocation;
    }

    public static String generateSysDumpLog() throws InterruptedException {
        try {
            File issueReport = new File(Environment.getExternalStorageDirectory(), "IssueReport");
            if (!issueReport.exists())
                issueReport.mkdir();
            File logFile = new File(issueReport,"dump-.txt");
            logFile.createNewFile();

            Process process = Runtime.getRuntime().exec("/system/bin/sh -");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(generateSysDumpCommond);

//            process.waitFor();
            logLocation = "/sdcard/IssueReport/sysdump.txt";
            Log.d("Client", logLocation);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return logLocation;
    }
}
