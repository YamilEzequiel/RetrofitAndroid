package com.hobbyappgame.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hobbyappgame.retrofit.Interfaz.MiniTwitterService;
import com.hobbyappgame.retrofit.Interfaz.RequestAuth;

import retrofit2.Call;

public class Login extends AppCompatActivity {

    EditText Usuario,Contraseña;
    Button BotonLogin;
    String nombre,apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Usuario = findViewById(R.id.Nombre);
        Contraseña = findViewById(R.id.Contraseña);
        BotonLogin = findViewById(R.id.Boton);


        BotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    nombre=Usuario.getText().toString();
                    apellido=Contraseña.getText().toString();

                    GoLogin(nombre,apellido);
            }
        });



    }

    private void GoLogin(String nombre, String apellido) {

    }




}
