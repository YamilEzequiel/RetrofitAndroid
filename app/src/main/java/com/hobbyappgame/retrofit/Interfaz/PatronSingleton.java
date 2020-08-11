package com.hobbyappgame.retrofit.Interfaz;

import com.hobbyappgame.retrofit.common.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatronSingleton {

    private static PatronSingleton instance = null; //Estatica, con la posibilidad de acceder a ella sin instanciarla
    private MiniTwitterService singletonService; //Controlador de llamadas hacia la API
    private Retrofit mRetrofit;

    //Patron de diseño, creamos una instancia de conexion solo una vez para luego acceder a ella varias veces
    //Sin consumir mas recursos.

    public PatronSingleton(){ //Metodo Constructor de la Clase PatronSingleton

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_PROYECT_BASE_URL) //Base URL
                .addConverterFactory(GsonConverterFactory.create()) //Convertidor GSON utilizado para JSON
                .build(); //Execute

        singletonService = mRetrofit.create(MiniTwitterService.class); //Instanciamos el servico con el llamador API

    } //Fin del metodo Constructor


    //Metodo del cual devolvera un objeto de la llamada API
    //El patron singleton solo se iniciara una vez
    public static PatronSingleton  getInstance(){
        if (instance == null){ //Si la instancia es nula se instancia por primera vez
            instance=new PatronSingleton();
        }

        return instance; //Una vez ya creada devuelve la instancia ya creada
    }


    public MiniTwitterService getSingletonService(){
        return singletonService;
    }

}
