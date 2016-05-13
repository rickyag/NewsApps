package com.example.rikirikmen.newsapps;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.rikirikmen.newsapps.Network.ApiService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String API_URL = "https://hacker-news.firebaseio.com/";
//        DownloadTask task = new DownloadTask();
//        try {
//            String result = task.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty").get();
//            Log.i("Result", result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .build();

        ApiService service = retrofit
                .create(ApiService.class);

        Call<List<Integer>> listCall = service.getTopStories();

        listCall.enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                if (response.isSuccessful()) {

                    Log.i("Result", String.valueOf(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });

    }

//    public class DownloadTask extends AsyncTask<String, Void, String> {
//
//
//        @Override
//        protected String doInBackground(String... urls) {
//
//            String result = "";
//            URL url;
//            HttpURLConnection urlConnection = null;
//
//            try {
//
//                url = new URL(urls[0]);
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//
//                InputStream in = urlConnection.getInputStream();
//
//                InputStreamReader reader = new InputStreamReader(in);
//
//                int data = reader.read();
//
//                while (data!= -1){
//
//                    char current = (char) data;
//
//                    result += current;
//
//                    data = reader.read();
//
//                }
//
//                return result;
//            }catch (Exception e){
//                e.printStackTrace();
//
//            }
//
//            return null;
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
