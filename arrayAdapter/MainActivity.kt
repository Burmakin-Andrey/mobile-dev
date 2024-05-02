package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.DialogAddPersonBinding
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupArrayAdapter()

        binding.buttonAddItem.setOnClickListener { onClickAddItem() }

    }


    private fun setupArrayAdapter(){

        val names = resources.getStringArray(R.array.names).toCollection(ArrayList())
        val surnames = resources.getStringArray(R.array.surnames).toCollection(ArrayList())

        var list = mutableListOf<String>()

        for (i in 0..10){
            val name = names[Random().nextInt(names.size)]
            val surname = surnames[Random().nextInt(surnames.size)]
            list.add("$name $surname")
        }

        adapter = ArrayAdapter(
            this,
            R.layout.adapter_item,
            R.id.textViewName,
            list
        )


        binding.listView.adapter = adapter
    }

    private fun onClickAddItem(){
        val dialogBinding = DialogAddPersonBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Add person")
            .setView(dialogBinding.root)
            .setPositiveButton("Add"){ dialog, which ->
                val name = dialogBinding.textViewAddName.text.toString()
                if (name.isNotBlank())
                    adapter.add(name)

            }

        dialog.show()
    }
}