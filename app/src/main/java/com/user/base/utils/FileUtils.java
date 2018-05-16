package com.user.base.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

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

        File externalCacheDir = context.getExternalCacheDir();
        File apkDir = new File(externalCacheDir,"apk");
        if(!apkDir.exists()){
            apkDir.mkdirs();
        }

        try {
            File apkFile = new File(apkDir, fileName);
            if (apkFile.exists()) {
                apkFile.delete();
            } else {
                apkFile.createNewFile();
            }
            return apkFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void installApk(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri uri = FileProvider.getUriForFile(context, "com.user.base.fileprovider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
