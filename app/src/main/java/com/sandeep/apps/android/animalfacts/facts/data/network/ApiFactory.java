package com.sandeep.apps.android.animalfacts.facts.data.network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sandeep on 14/3/18.
 */

public class ApiFactory {
    private OkHttpClient client;
    private Retrofit retrofit;
    private Map<String, Object> apiMap;
    private static final String baseUrl = "https://cat-fact.herokuapp.com";

    public ApiFactory() {
        apiMap = new HashMap<>();
        init();
    }

    private void init() {
        retrofit = createRetrofitInstance();
    }

    private Retrofit createRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(logging);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requesBuilder = original.newBuilder()
                        .header("content_type", "application/json")
                        .header("authorization", "auth_token")
                        .method(original.method(), original.body());

                addCommonHeaders(requesBuilder);
                Request request = requesBuilder.build();
                return chain.proceed(request);
            }
        });

        client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void addCommonHeaders(Request.Builder requestBuilder) {

    }

    @SuppressWarnings("unchecked")
    public <T> T getApi(Class<T> apiClass) {
        T api = (T) apiMap.get(apiClass.getName());
        if (api == null) {
            api = retrofit.create(apiClass);
            apiMap.put(apiClass.getName(), api);
        }
        return api;
    }

    public OkHttpClient getClient() {
        return client;
    }
}
