package com.example.newsupdates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsupdates.CustomAdapter.CustomAdapterParent;
import com.example.newsupdates.ViewClass.*;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity  {
 RecyclerView recyclerView;
 List<parentViewClass> categoryList;
// TextView textView;

//   List<ResponseNews.article> responseArticle;
    List<ChildViewClass> childList;
    ResponseNews responseNews;
    ProgressBar progressBar;
   List<ChildViewClass> healthList,sportsList,technologyList,businessList,entertainmentList;
     public final String country="in";
     public final String apiKey=BuildConfig.apiKey;
    CustomAdapterParent adapterParent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_NewsUpdates);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.parent_recyclerview);
        categoryList=new ArrayList<>();
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

          loadData(country,"health",apiKey);
          loadData(country,"technology",apiKey);
          loadData(country, "sports", apiKey);
          loadData(country, "business", apiKey);
          loadData(country, "entertainment", apiKey);
    }

  public void loadData(String country,String category,String apiKey){
        Retrofit retrofit= ApiClient.getClient();
       ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        apiInterface.getNews(country,category,apiKey).enqueue(new Callback<ResponseNews>() {
                  @Override
                  public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                      if (response.isSuccessful()) {
                          responseNews=response.body();
                          List<ResponseNews.article> articles=responseNews.getArticles();
                          progressBar.setVisibility(View.GONE);

                          childList=new ArrayList<>();
                          switch (category){
                              case"health":
                                  healthList=new ArrayList<>();
                                 childList=setChildList(healthList,articles);
                                  break;
                              case"technology":
                                  technologyList=new ArrayList<>();
                                  childList=setChildList(technologyList,articles);
                                  break;
                              case"sports":
                                  sportsList=new ArrayList<>();
                                  childList=setChildList(sportsList,articles);
                                  break;
                              case"entertainment":
                                  entertainmentList=new ArrayList<>();
                                  childList=setChildList(entertainmentList,articles);
                                  break;
                              case"business":
                                  businessList=new ArrayList<>();
                                  childList=setChildList(businessList,articles);
                                  break;
                          }
                             categoryList.add(new parentViewClass(category,childList));
                              setAdapterParent(categoryList);


                      } else {
                          Toast.makeText(MainActivity.this, "Sorry response is not successful", Toast.LENGTH_SHORT).show();
                      }
                  }


            @Override
                  public void onFailure(Call<ResponseNews> call, Throwable t) {
                      Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                  }
              });

    }
    public List<ChildViewClass> setChildList(List<ChildViewClass> childListparam,List<ResponseNews.article> articles){
        for(ResponseNews.article article1:articles){
            try {
                childListparam.add(new ChildViewClass(article1.getUrlToImage(),article1.getTitle(), article1.getPublishedAt(),article1.getUrl()));
            }catch (Exception e){
                Toast.makeText(MainActivity.this,article1.getTitle(),Toast.LENGTH_SHORT ).show();
            }
        }

        return childListparam;
    }
   public void setAdapterParent(List<parentViewClass> list2){
       LinearLayoutManager
               layoutManager
               = new LinearLayoutManager(
               MainActivity.this);
       adapterParent = new CustomAdapterParent(this,list2);
       recyclerView.setAdapter(adapterParent);
       recyclerView.setLayoutManager(layoutManager);
   }

  }



