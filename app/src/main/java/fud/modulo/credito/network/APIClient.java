package fud.modulo.credito.network;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static APIRequest apiRequest;
    private static final String BASE_URL = "<tu back>";


    public static APIRequest getInstance(){
        if(apiRequest == null){
            OkHttpClient httpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiRequest = retrofit.create(APIRequest.class);

            return apiRequest;
        }else{
            return apiRequest;
        }
    }
}
