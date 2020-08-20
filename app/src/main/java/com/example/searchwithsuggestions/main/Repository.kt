package com.mrk.compaq.application.local.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mrk.compaq.application.local.ui.main.data.SearchDbase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Repository(val app:Application){
val queries: LiveData<List<Model>>
    private val dao= SearchDbase.getDbInstance(app).searchDao()

    init{
       /* CoroutineScope(Dispatchers.IO).launch {
          val data=dao.getAll()
            if(data.isNotEmpty()){
                queries.postValue(data)
            }
        }*/
        queries=dao.getAll()
      /*  Log.e("Er", data.value?.size.toString())
        data.value?.let {
            Log.e("Er", ": " )
            if(it.isNotEmpty()){
                Log.e("Erp", ": " )
                queries.postValue(data.value)
            }
        }*/

    }

    fun insertQueries(query:String){
        CoroutineScope(Dispatchers.IO).launch {
           dao.insertModel(Model(query))
        }
    }
}