package com.mirea.kateninva.retrofitapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kateninva.retrofitapp.ApiWork.ApiService;
import com.mirea.kateninva.retrofitapp.ApiWork.RetrofitClient;
import com.mirea.kateninva.retrofitapp.ApiWork.ToDo;
import com.mirea.kateninva.retrofitapp.RecView.ToDoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ToDoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchTodos();
    }

    private void fetchTodos() {
        ApiService todoApi = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<List<ToDo>> call = todoApi.getTodos();

        call.enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    todoAdapter = new ToDoAdapter(MainActivity.this, response.body());
                    recyclerView.setAdapter(todoAdapter);
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Log.e(TAG, "onFailure:	" + t.getMessage());
            }
        });
    }

}