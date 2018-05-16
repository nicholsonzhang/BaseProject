package com.base.library.listener;

import java.io.File;

/**
 * 文件下载相关listener
 */
public interface OnProgressListener {

    void onProgress(long progress, long total, boolean done);

    void onComplete(File outFile);
}
