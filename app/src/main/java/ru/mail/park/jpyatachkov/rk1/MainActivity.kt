package ru.mail.park.jpyatachkov.rk1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = SingleNumberAdapter(numbersList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        private const val LIST_SIZE = 100
        private val numbersList = (1..LIST_SIZE).toList().toIntArray()
    }
}
