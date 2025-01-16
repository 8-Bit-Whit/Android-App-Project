package edu.msudenver.cs3013.project2_s24
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//fragment that displays fun STEM facts including the number facts and NASA APOD images
class fun_stem_facts_Fragment : Fragment() {
    // UI components
    private lateinit var factTextView: TextView
    private lateinit var numberTextView: TextView
    private lateinit var typeTextView: TextView
    private lateinit var fetchFactButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var apodAdapter: APODAdapter

    // API service instances from our NetworkModule
    private val numbersApiService = NetworkModule.numbersApiService
    private val nasaApiService = NetworkModule.nasaApiService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fun_stem_facts_, container, false)

        // Initialize UI components
        factTextView = view.findViewById(R.id.factTextView)
        numberTextView = view.findViewById(R.id.numberTextView)
        typeTextView = view.findViewById(R.id.typeTextView)
        fetchFactButton = view.findViewById(R.id.fetchNumberFactButton)
        recyclerView = view.findViewById(R.id.apodRecyclerView)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        apodAdapter = APODAdapter()
        recyclerView.adapter = apodAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchFactButton.setOnClickListener {
            fetchNumberFact()
        }

        fetchNumberFact()
        fetchApodData()
    }
//this function fetches the number fact
    private fun fetchNumberFact() {
        numbersApiService.getRandomMathFact().enqueue(object : Callback<NumberFact> {
            override fun onResponse(call: Call<NumberFact>, response: Response<NumberFact>) {
                if (response.isSuccessful) {
                    val numberFact = response.body()
                    numberFact?.let {
                        updateUI(it)
                    }
                } else {
                    showError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NumberFact>, t: Throwable) {
                showError("Network error: ${t.message}")
            }
        })
    }
//this function fetches the APOD data
    private fun fetchApodData() {
        nasaApiService.getApod("lHAXUn7qMfdkQtoOUAt2BtvrgZQ90ei0B5JFnrMT", 5).enqueue(object : Callback<List<ApodItem>> {
            override fun onResponse(call: Call<List<ApodItem>>, response: Response<List<ApodItem>>) {
                if (response.isSuccessful) {
                    response.body()?.let { apodItems ->
                        apodAdapter.submitList(apodItems)
                    }
                } else {
                    showError("APOD Error: ${response.code()}")
                }
            }
//this function shows an error message if the network call fails
            override fun onFailure(call: Call<List<ApodItem>>, t: Throwable) {
                showError("APOD Network error: ${t.message}")
            }
        })
    }
    //this function updates the UI with the number fact
    private fun updateUI(numberFact: NumberFact) {
        factTextView.text = numberFact.fact
        numberTextView.text = "Number: ${numberFact.number}"
        typeTextView.text = "Type: ${numberFact.type}"
    }
//this function shows an error message if the network call fails
    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}