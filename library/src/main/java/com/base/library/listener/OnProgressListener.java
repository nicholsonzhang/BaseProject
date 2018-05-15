package com.base.library.listener;

public interface OnProgressListener {

    void onProgress(long progress, long total, boolean done);

    void onComplete();
}
