package com.user.base.http;

/**
 * Created by user on 2017/10/10.
 * 服务端返回数据结构
 */

public class BaseResponse<T> {
    private int status = -1;
    private T result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
