import com.example.rental.Car
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody

fun sendGetRequest(url: String): ResponseBody {
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    val response = client.newCall(request).execute()
    return response.body
}
