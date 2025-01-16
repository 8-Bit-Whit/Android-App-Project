import edu.msudenver.cs3013.project2_s24.NumberFact
import retrofit2.Call
import retrofit2.http.GET
//This is the interface for the Numbers API service.
interface NumbersApiService {
    //This annotation tells Retrofit that this is a GET request, and specifies the endpoint.
    // The full URL will be the base URL + this endpoint.
    @GET("random/math?json")
    //This function declaration tells Retrofit: returns a Call<NumberFact> object,
// where NumberFact is the data class that represents the JSON response.
    fun getRandomMathFact(): Call<NumberFact>
}
