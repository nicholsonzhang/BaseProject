package com.user.base.http;

import com.user.base.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 2017/8/10.
 */

public interface RequestApi {

    @GET("user/{userId}")
    Observable<UserInfo> getUserInfo(@Path("userId") String userId);

}
