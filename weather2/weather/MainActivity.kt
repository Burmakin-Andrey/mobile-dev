package com.example.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.weather.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.InputStream
import java.net.URL
import java.net.UnknownHostException
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var etCity: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        etCity = findViewById(R.id.etCity)

    }
    private suspend fun loadWeather() {
        val API_KEY = getString(R.string.API_KEY) // TODO: ключ загрузить из строковых ресурсов
        // TODO: в строку подставлять API_KEY и город (выбирается из списка или вводится в поле)
        val city = etCity.text.toString()
        val weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$API_KEY&units=metric"

        try {

            val stream = URL(weatherURL).getContent() as InputStream
            val data = Scanner(stream).nextLine()
            val weather = Gson().fromJson(data, WeatherData::class.java)
            val dayLenght = DayLenght()
            dayLenght.dayLength = weather.weather?.sunset!! - weather.weather.sunrise!!
            binding.dayLenght = dayLenght

        } catch (e: java.lang.Exception)
        {
            binding.dayLenght = DayLenght()

        }

    }
    @OptIn(DelicateCoroutinesApi::class)
    fun onClick(v: View) {
        // Используем IO-диспетчер вместо Main (основного потока)
        GlobalScope.launch (Dispatchers.IO) {
            loadWeather()
        }
    }
}


