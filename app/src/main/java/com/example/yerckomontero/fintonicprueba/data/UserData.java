package com.example.yerckomontero.fintonicprueba.data;

import android.content.Context;

import com.example.yerckomontero.fintonicprueba.models.Heroe;
import com.example.yerckomontero.fintonicprueba.models.HeroesList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yerckomontero on 1/2/18.
 */

public class UserData {
    private static UserData instance = null;
    private static HeroesList heroes;

    public UserData(){
        super();
    }
    /**
     * Static method
     * @return current class instance
     */
    public static UserData getInstance(Context context){

        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }


    public HeroesList getHeroes() {
        return heroes;
    }

    public void setHeroes(HeroesList heroes) {
        UserData.heroes = heroes;
    }
}
