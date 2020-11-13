package com.oldfredddy.lessonsqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.oldfredddy.lessonsqlitekotlin.db.MyDbManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPostResume() {
        super.onPostResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()

        for (item in dataList) {
            tvTest.append(item + "\n")
        }

    }

    fun onClickSave(view: View) {
        tvTest.text = ""
        myDbManager.insertToDb(edTitle.text.toString(), edContent.text.toString())
        val dataList = myDbManager.readDbData()

        for (item in dataList) {
            tvTest.append(item + "\n")
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}

