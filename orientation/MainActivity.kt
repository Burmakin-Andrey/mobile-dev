package ru.myitschool.portraitlandscapepresentk

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var iv :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById<ImageView>(R.id.picture)
        // TODO: заменять картинку на ту, которую установили при нажатии кнопки
        // иначе будет исходная с котиком
        savedInstanceState?.let {
            //iv.setImageDrawable(BitmapDrawable(it.getParcelable("IMG") as Bitmap?))
            count = it.getInt("CNT")
            when (count) {
                0 -> return
                1 -> iv.setImageResource(R.drawable.car1)
                2 -> iv.setImageResource(R.drawable.car2)
                3 -> iv.setImageResource(R.drawable.car3)
            }
        }
    }

    fun onChangePictureClick(v: View) {
        count+=1
        if (count == 4) count = 1
        // TODO: картинку менять по очереди на следущую
        when (count) {
            1 -> iv.setImageResource(R.drawable.car1)
            2 -> iv.setImageResource(R.drawable.car2)
            3 -> {
                iv.setImageResource(R.drawable.car3)
            }
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("main", iv.drawable.toBitmap().toString())
//        outState.putParcelable("IMG", iv.drawable.toBitmap())
        outState.putInt("CNT", count)
    }
}