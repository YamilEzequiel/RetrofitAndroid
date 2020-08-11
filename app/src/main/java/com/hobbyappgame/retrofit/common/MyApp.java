package com.hobbyappgame.retrofit.common;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    //Instanciamos el contexto de la aplicacion en general e instanciamos el metodo onCreate por unica vez
    //instanciando en manifest desde aplication  android:name=".common.MyApp"

    private static MyApp instance;

    public static MyApp getInstance(){
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }


}
