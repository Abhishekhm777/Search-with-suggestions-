package com.mrk.compaq.application.local.ui.main.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mrk.compaq.application.local.ui.main.Model

@Database(entities = [Model::class],version = 5,exportSchema = false)
abstract  class SearchDbase : RoomDatabase() {

    abstract fun searchDao():SearchDao

    companion object{
        @Volatile
        private var INSTANCE :SearchDbase?=null

        fun getDbInstance(context:Context):SearchDbase{
            if(INSTANCE ==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(
                            context.applicationContext,
                            SearchDbase::class.java,
                            "search.db"

                    ).addMigrations(migration)
                            .build()
                }
            }
            return  INSTANCE!!
        }

        private val migration = object:Migration(4,5){
            override fun migrate(database: SupportSQLiteDatabase) {

            }

        }
    }
}