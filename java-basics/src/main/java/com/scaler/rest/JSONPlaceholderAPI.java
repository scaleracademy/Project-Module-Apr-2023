package com.scaler.rest;

import com.scaler.rest.models.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface JSONPlaceholderAPI {
    @GET("/photos")
    Call<List<Photo>> getPhotos();

}
