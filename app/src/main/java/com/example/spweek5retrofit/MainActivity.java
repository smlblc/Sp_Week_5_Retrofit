package com.example.spweek5retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.spweek5retrofit.model.Photo;
import com.example.spweek5retrofit.model.TeamsItem;
import com.example.spweek5retrofit.network.GetDataService;
import com.example.spweek5retrofit.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public List<Photo> teams;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyler_view);

        GetDataService getDataService = RetrofitClient.getRetrofit().create(GetDataService.class);

        //Call<List<TeamsItem>> callTeams = getDataService.getTeams();
        Call<List<Photo>> callTeams = getDataService.getPhotos();


        callTeams.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                //teamsItemList = response.body();
                teams = response.body();
                if (teams != null) {
                    createRecylerView();
                    for (Photo team : teams) {
                        Log.d("MyTeams", "My Teams: " + team.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }

    public void createRecylerView() {
        TeamsAdapter teamsAdapter = new TeamsAdapter(teams);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(teamsAdapter);


    }
}
