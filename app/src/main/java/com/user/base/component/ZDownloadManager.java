package com.user.base.component;

import java.io.File;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 使用此类进行下载相关的重构，不在依赖retrofit
 */
public class ZDownloadManager {
    private ZDownloadManager() {

    }

    public static ZDownloadManager getInstance() {
        return ZDownloadManagerHolder.holder;

    }

    private static class ZDownloadManagerHolder {
        private static ZDownloadManager holder = new ZDownloadManager();
    }



    public void download(String url, String path, String name, final OnProgressListener onProgressListener) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new FileDownloadCallBack(path, name) {
            @Override
            public void onSuccess(File file, Call call, Response response) {
                if (onProgressListener != null) {
                    onProgressListener.onComplete(file);
                }

            }

            @Override
            public void onDownloading(int progress) {
                if (onProgressListener != null) {
                    onProgressListener.onProgress(progress);
                }
            }

            @Override
            public void onDownloadFailed() {
                if (onProgressListener != null) {
                    onProgressListener.onDownloadFail();
                }
            }
        });
    }
}
