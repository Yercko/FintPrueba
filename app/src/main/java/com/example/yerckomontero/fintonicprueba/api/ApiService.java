package com.example.yerckomontero.fintonicprueba.api;

import com.example.yerckomontero.fintonicprueba.models.Heroe;
import com.example.yerckomontero.fintonicprueba.models.HeroesList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by yercko on 16/08/2017.
 */

public interface ApiService {
    @GET("/bins/bvyob")
    Call<HeroesList> getHeroes();



}
