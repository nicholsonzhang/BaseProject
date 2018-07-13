package com.user.base.component;

/**
 * 使用此类进行上传相关的重构，不在依赖retrofit
 */
public class ZUploadManager {
    private ZUploadManager() {

    }

    public static ZUploadManager getInstance() {
        return ZUploadManagerHolder.holder;
    }

    private static class ZUploadManagerHolder {
        private static ZUploadManager holder = new ZUploadManager();
    }
}
