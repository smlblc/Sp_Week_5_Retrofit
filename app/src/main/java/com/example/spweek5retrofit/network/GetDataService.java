package com.example.spweek5retrofit.network;

import com.example.spweek5retrofit.model.Photo;
import com.example.spweek5retrofit.model.TeamsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    //    @GET("/bttmly/nba/blob/master/data/teams.json")
//    Call<List<TeamsItem>> getTeams();
    @GET("/photos")
    Call<List<Photo>> getPhotos();

}
