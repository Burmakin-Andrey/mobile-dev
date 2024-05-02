package com.example.weather

import com.google.gson.annotations.SerializedName

data class WeatherData(

    @SerializedName("sys")
    val weather: Weather?

)
