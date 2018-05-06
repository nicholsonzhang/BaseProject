package com.user.base.http;

import com.base.library.http.BaseResponseBody;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by user on 2017/8/10.
 */

public interface RequestApi {

    @GET("test/")
    Observable<BaseResponseBody<String>> testInfo(@Query("key") String key);

}
