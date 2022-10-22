package com.example.urgence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

import api.Api;
import api.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton button;
    private ImageView button2;
    private FloatingActionButton remorque;
    private  static final String BASE_URL="http://10.0.2.2:3000/api/";
    private Retrofit retrofit;
    private Api retrofitInterface;
    private RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       retrofitInterface=retrofit.create(Api.class);

        button=findViewById(R.id.home_btn);
        button2= findViewById(R.id.about);
        remorque=findViewById(R.id.remorque);

        remorque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleAlertSending();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutActivity();
            }
        });

    }

    public void openLoginActivity(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void openAboutActivity(){
        Intent intent=new Intent(this,AboutActivity2.class);
        startActivity(intent);
    }
    public void handleAlertSending(){

        String userRef= "aziz azouni";
        String typeAlert= "remorque";
        String longg= "current longg";
        String lat= "current lat";

        Call<ResponseBody> call=retrofitClient
                .getInstance().getApi()
                .store(userRef,typeAlert,longg,lat);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()==200){
                    Toast.makeText(MainActivity.this,"alert sent succesfully",Toast.LENGTH_LONG).show();
                }else{ Toast.makeText(MainActivity.this,"something's wrong!!",Toast.LENGTH_LONG).show();
            }}

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}