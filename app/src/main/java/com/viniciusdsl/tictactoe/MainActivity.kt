package com.viniciusdsl.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.viniciusdsl.tictactoe.with_andengine.AndengineGameActivity
import com.viniciusdsl.tictactoe.without_engine.NativeUIActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNativeUI.apply {
            (this as Button).text = getString(R.string.button_native_ui)
            setOnClickListener {
                startActivity(Intent(context, NativeUIActivity::class.java))
            }
        }

        buttonAndengine.apply {
            (this as Button).text = getString(R.string.button_andengine)
            setOnClickListener {
                startActivity(Intent(context, AndengineGameActivity::class.java))
            }
        }
    }
}