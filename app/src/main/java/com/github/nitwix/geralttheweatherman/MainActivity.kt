package com.github.nitwix.geralttheweatherman

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun onRefreshClick(item: MenuItem) {
        val weatherCommentaries: List<String> =
            resources.getStringArray(R.array.weather_commentaries).toList()
        val tv = findViewById<TextView>(R.id.activity_main_geralt_wc_text_view)
        tv.text = weatherCommentaries.random()
    }
}

