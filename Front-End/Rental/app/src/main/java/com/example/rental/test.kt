import com.example.rental.Car
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

// fun sendGetRequest(url: String): String {
//     val client = OkHttpClient()
//     val request = Request.Builder().url(url).build()
//     val response = client.newCall(request).execute()
//     return response.body.toString()
// }

// fun sendGetRequest(url: String): String {
//     val client = OkHttpClient()
//     val request = Request.Builder().url(url).build()
//     val response = client.newCall(request).execute()
//     return response.body?.string() ?: ""
// }
fun sendLoginRequest(url: String, email: String, password: String): String {
   val client = OkHttpClient()

   val json = """{"email": "$email", "password": "$password"}"""
   val body = json.toRequestBody("application/json".toMediaType())

   val request = Request.Builder()
        .url(url)
        .post(body)
        .build()

    val response = client.newCall(request).execute()
    //val responseBody = response.body?.string()

    return response.body?.string() ?: ""
}