package com.cyn.demo.httpClient;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-26
 */
public class HttpTest {
    @Test
    public void testT() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("ids","88c30cdf-0f80-47a4-abaf-6bdb08c2d1c2")
                .addFormDataPart("names","yongchen892")
                .build();
        Request request = new Request.Builder()
                .url("http://172.30.12.224:8888/rest/user/del")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();

    }
}
