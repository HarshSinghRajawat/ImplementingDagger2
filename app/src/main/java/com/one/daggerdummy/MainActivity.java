package com.one.daggerdummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.one.daggerdummy.Retrofit.Data;
import com.one.daggerdummy.Retrofit.RetroNetworkInterface;

import java.util.List;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Inject
    Retrofit retrofit;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar bar=findViewById(R.id.progressBar);

        recyclerView=findViewById(R.id.list);
        GridLayoutManager mGrid=new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);

        ((CustomApplication)getApplication()).getNetworkComponent().inject(this);

        RetroNetworkInterface mService=retrofit.create(RetroNetworkInterface.class);
        Call<List<Data>> list=mService.getToDoItems();

        list.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,response.body());
                recyclerView.setAdapter(myAdapter);
                bar.setVisibility(View.GONE);
                Log.d(TAG, response.code()+"");
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });


    }
}