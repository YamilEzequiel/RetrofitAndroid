package com.hobbyappgame.retrofit.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hobbyappgame.retrofit.Interfaz.MiniTwitterService;
import com.hobbyappgame.retrofit.Model.AdapterRecycler;
import com.hobbyappgame.retrofit.Model.GetBebes;
import com.hobbyappgame.retrofit.R;
import com.hobbyappgame.retrofit.common.Constantes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<GetBebes> mArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private AdapterRecycler mAdapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.RecyclerView);

        //getPosts();
    }


    private void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_PROYECT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final MiniTwitterService jsonPlaceHolderApi = retrofit.create(MiniTwitterService.class);

        Call<List<GetBebes>> call = jsonPlaceHolderApi.getBebesMasculino();

        call.enqueue(new Callback<List<GetBebes>>() {
            @Override
            public void onResponse(Call<List<GetBebes>> call, Response<List<GetBebes>> response) {
               // if(!response.isSuccessful()){
                   // mJsonTxtView.setText("Codigo: "+response.code());


                    assert response.body() != null;
                    mArrayList=new ArrayList<>(response.body());

                    mAdapterRecycler=new AdapterRecycler(mArrayList,getApplicationContext());

                    LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(llm);
                    DividerItemDecoration LinealRecycler = new DividerItemDecoration(MainActivity.this, llm.getOrientation());
                    mRecyclerView.addItemDecoration(LinealRecycler);
                    mRecyclerView.setAdapter(mAdapterRecycler);



               // }

                /*
                List<Posts> postsList = response.body();
                for(Posts post: postsList){
                    String content = "";
                    content += "userId:"+ post.getUserId() + "\n";
                    content += "id:"+ post.getId() + "\n";
                    content += "title:"+ post.getTitle() + "\n";
                    content += "body:"+ post.getBody() + "\n\n";
                    mJsonTxtView.append(content);
                }*/
            }
            @Override
            public void onFailure(Call<List<GetBebes>> call, Throwable t) {
                //mJsonTxtView.setText(t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}