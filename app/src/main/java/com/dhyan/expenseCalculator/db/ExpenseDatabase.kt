package com.dhyan.expenseCalculator.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.dhyan.expenseCalculator.models.AutoModel
import com.dhyan.expenseCalculator.models.MainModel

@Database(
    entities = [MainModel::class,AutoModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ExpenseDatabase:RoomDatabase() {
    abstract fun getArticleDao():ExpenseDao
    abstract fun getAutoDao():AutoDao

    companion object{
        @Volatile
        private var instance:ExpenseDatabase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance=it}
        }
        private fun createDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            ExpenseDatabase::class.java,
            "expense_db.db"
        ).build()
    }
}