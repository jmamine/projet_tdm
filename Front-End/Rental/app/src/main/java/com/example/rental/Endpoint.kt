package com.example.rental

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*


interface Endpoint {



//    @POST("login/")
//    suspend fun login(@Body data: amine): Response<User?>

    //@POST("signup/")
    //suspend fun signup(@Body data: user ):Response<user?>

    @GET("all_objects")
    suspend fun getCar():Response<List<Car>>
//
//    @FormUrlEncoded
//    @POST("login")
//    suspend fun login(@Field("email") email: String,@Field("password") password: String ):Call<User>


//    @POST("login")
//    suspend fun login(@Body data: amine): Response<User?>

//    @FormUrlEncoded
//    @POST("login")
//    suspend fun sendLoginRequest(
////        @Url url: String,
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): Call<Response<User?>>
//}

//fun sendLoginRequest(url: String, email: String, password: String): String {
//    val retrofit = Retrofit.Builder()
//        .baseUrl(url)
//        .addConverterFactory(ScalarsConverterFactory.create())
//        .build()
//
//    val apiService = retrofit.create(ApiService::class.java)
//
//    val call = apiService.sendLoginRequest(url, email, password)
//
//    val response = call.execute()
//
//    return response.body() ?: ""
//}
//
//
//
//
//
//
//
////    @Multipart
////    @POST("adduser")
////    suspend fun addPDV(@Part image: MultipartBody.Part,
////                       @Part user:MultipartBody.Part):Response<String>
//
//
}