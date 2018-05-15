package com.user.base.utils;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static void writeToFile(InputStream inputStream, File outFile) {

        if (outFile == null) return;
        FileOutputStream fileOutputStream = null;
        try {
            if (outFile.exists()) {
                outFile.delete();
            } else {
                outFile.createNewFile();
            }

            fileOutputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int read;

            while ((read = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static File getApkPath(Context context, String fileName) {
        File cacheFileDir = context.getExternalCacheDir();
        File apkFile = new File(cacheFileDir, fileName);
        return apkFile;

    }
}
