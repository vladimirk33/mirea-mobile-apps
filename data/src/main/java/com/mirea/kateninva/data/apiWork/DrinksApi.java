package com.mirea.kateninva.data.apiWork;


import retrofit2.Call;
import retrofit2.http.GET;

public interface DrinksApi {

    @GET("random.php")
    Call<DrinksResponse> getRandomDrink();

}
