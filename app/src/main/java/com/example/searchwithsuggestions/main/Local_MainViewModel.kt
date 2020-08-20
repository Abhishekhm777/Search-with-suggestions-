package com.mrk.compaq.application.local.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel

public class Local_MainViewModel(val app: Application) : AndroidViewModel(app) {

    fun insert(s: String) {
        repo.insertQueries(s)
    }

    private val repo = Repository(app)

   val data=repo.queries
}