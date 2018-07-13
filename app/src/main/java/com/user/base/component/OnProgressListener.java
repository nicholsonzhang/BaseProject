package com.user.base.component;

import java.io.File;

public interface OnProgressListener {

    void onProgress(int progress);

    void onComplete(File file);

    void onDownloadFail();

    void onDownloadStart();

}
