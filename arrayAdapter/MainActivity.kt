package com.example.arrayad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.arrayad.databinding.ActivityMainBinding
import com.example.arrayad.databinding.DialogAddPersonBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

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