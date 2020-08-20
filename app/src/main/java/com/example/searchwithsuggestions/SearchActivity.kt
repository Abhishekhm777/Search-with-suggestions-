package com.example.searchwithsuggestions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val intent =Intent(this,LocalActivity::class.java)
        startActivity(intent)
        return  true
    }
}