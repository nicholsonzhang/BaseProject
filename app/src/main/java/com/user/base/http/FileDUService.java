package com.user.base.http;

import com.base.library.http.BaseResponseBody;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface FileDUService {

    @Multipart
    @POST
    Observable<BaseResponseBody<String>> uploadSingleFile(@Url String url, @Part MultipartBody.Part part);

    @Streaming
    @GET
    Observable<ResponseBody>  downloadFile(@Url String fileUrl);
}
