package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var movies:  ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = resources.getStringArray(R.array.movies).toCollection(ArrayList())


        buttonNextMovie.setOnClickListener {
            if (movies.size <=0)
                textViewMovies.text = "Фильмы кончились"
            else{
                val i = Random().nextInt(movies.size)

                textViewMovies.text = movies[i]
                movies.removeAt(i)

            }
        }

        buttonUpdate.setOnClickListener{
            movies = resources.getStringArray(R.array.movies).toCollection(ArrayList())
            textViewMovies.text = "Нажми на кнопку"
        }

    }
}