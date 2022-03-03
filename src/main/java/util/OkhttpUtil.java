package util;

import okhttp3.*;

import java.io.IOException;


/**
 * @author: chenyutao
 * @date: 2022/2/23 3:49 下午
 */
public class OkhttpUtil {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String post(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}