package com.example.pam4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var name1: EditText
    private lateinit var name2: EditText
    private lateinit var btnSimpan: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DataAdapter
    private val dataList: MutableList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name1 = findViewById(R.id.name1)
        name2 = findViewById(R.id.name2)
        btnSimpan = findViewById(R.id.btn_simpan)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter

        btnSimpan.setOnClickListener {
            val inputName1 = name1.text.toString()
            val inputName2 = name2.text.toString()

            if (inputName1.isNotEmpty() && inputName2.isNotEmpty()) {
                dataList.add(DataModel(inputName1, inputName2))
                adapter.notifyDataSetChanged()
                name1.setText("")
                name2.setText("")
            }
        }
    }
}