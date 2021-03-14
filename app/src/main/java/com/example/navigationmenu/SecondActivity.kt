package com.example.navigationmenu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tvColor: TextView
    lateinit var tvSize: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvColor = findViewById(R.id.textView)
        tvSize = findViewById(R.id.textView2)

        registerForContextMenu(tvColor)
        registerForContextMenu(tvSize)
    }


    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        when (v) {
            tvColor -> {
                menu.add(0, 0, 0, "Красный")
                menu.add(0, 1, 0, "Зелёный")
                menu.add(0, 2, 0, "Синий")
            }
            tvSize -> {
                menu.add(0, 3, 0, "22")
                menu.add(0, 4, 0, "32")
                menu.add(0, 5, 0, "42")
                menu.add(0, 6, 0, "Вернуться на первый экран")
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            0 -> {
                tvColor.setTextColor(Color.parseColor("#FF0000"))
                tvColor.text = "Красный"
            }
            1 -> {
                tvColor.setTextColor(Color.parseColor("#00FF00"))
                tvColor.text = "Зеленый"
            }
            2 -> {
                tvColor.setTextColor(Color.parseColor("#0000FF"))
                tvColor.text = "Синий"
            }
            3 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22F)
                tvSize.text = "Шрифт - 22"
            }
            4 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32F)
                tvSize.text = "Шрифт - 32"
            }
            5 -> {
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42F)
                tvSize.text = "Шрифт - 42"
            }
            6 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onContextItemSelected(item)
    }
}