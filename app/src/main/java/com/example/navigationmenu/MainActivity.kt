package com.example.navigationmenu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // создаем пункты меню
        menu.add("Первый пункт")
        menu.add("Второй пункт")
        menu.add("Третий пункт")
        menu.add("Перейти на второй экран")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // метод, который выполняется при выборе определенного пункта меню
        if(item.title.toString() == "Перейти на второй экран")
        {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
        else Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    fun NextScreen(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        finish()
    }
}