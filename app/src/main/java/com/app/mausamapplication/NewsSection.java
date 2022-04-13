package com.app.mausamapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsSection extends AppCompatActivity {

    private RecyclerView newsRV;
    private ProgressBar loadingPB;
    private ArrayList<Articles> articlesArrayList;
    private NewsRVAdapter newsRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_section);
        newsRV= findViewById(R.id.idRVNews);
        loadingPB = findViewById(R.id.idPBLoading);
        articlesArrayList= new ArrayList<>();
        newsRVAdapter= new NewsRVAdapter(articlesArrayList,this);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(newsRVAdapter);
        getNews();
        newsRVAdapter.notifyDataSetChanged();

    }
    private void getNews(){
        loadingPB.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String url="https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=f59be6ba66bd42849e426016aea73c63";
        String BASE_URL= "https://newsapi.org/";
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI= retrofit.create(RetrofitAPI.class);
        Call<NewsModal>call;
        call = retrofitAPI.getAllNews(url);

        call.enqueue(new Callback<NewsModal>() {
            @Override
            public void onResponse(Call<NewsModal> call, Response<NewsModal> response) {
                NewsModal newsModal= response.body();
                loadingPB.setVisibility(View.GONE);
                ArrayList<Articles> articles= newsModal.getArticles();
                for (int i=0;i<articles.size();i++) {
                    articlesArrayList.add(new Articles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),
                            articles.get(i).getUrl(),articles.get(i).getContent()));

                }
                newsRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {

            }
        });
    }
}