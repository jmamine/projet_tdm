// import com.example.rental.Car
// import okhttp3.OkHttpClient
// import okhttp3.Request
// import okhttp3.ResponseBody
// import okhttp3.MediaType.Companion.toMediaType
// import okhttp3.RequestBody.Companion.toRequestBody
// import org.json.JSONObject

// // fun sendGetRequest(url: String): String {
// //     val client = OkHttpClient()
// //     val request = Request.Builder().url(url).build()
// //     val response = client.newCall(request).execute()
// //     return response.body.toString()
// // }

//  fun sendGetRequest(url: String): String {
//      val client = OkHttpClient()
//      val request = Request.Builder().url(url).build()
//      val response = client.newCall(request).execute()
//      return response.body?.string() ?: ""
//  }
// fun sendLoginRequest(url: String, email: String, password: String): String {
//    val client = OkHttpClient()

//    val json = """{"email": "$email", "password": "$password"}"""
//    val body = json.toRequestBody("application/json".toMediaType())

//    val request = Request.Builder()
//         .url(url)
//         .post(body)
//         .build()

//     val response = client.newCall(request).execute()
//     //val responseBody = response.body?.string()

//     return response.body?.string() ?: ""
// }

//import com.example.rental.User
//import okhttp3.FormBody
//import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*

//import okhttp3.FormBody
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST
    fun sendLoginRequest(
        @Url url: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<String>
}

fun sendLoginRequest(url: String, email: String, password: String): String {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    val call = apiService.sendLoginRequest(url, email, password)

    val response = call.execute()

    return response.body() ?: ""
}
interface ApiServicereservation {
    @FormUrlEncoded
    @POST
    fun sendreservationRequest(
        @Url url: String,
        @Field("car_id") car_id: String,
        @Field("user_email") user_email: String,
        @Field("date_debute") date_debut: String
    ): Call<String>
}

fun sendreservationRequest(url: String, car_id: String, user_email: String, date_debut: String): String {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiServicereservation::class.java)

    val call = apiService.sendreservationRequest(url, car_id, user_email, date_debut)

    val response = call.execute()

    return response.body() ?: ""
}


