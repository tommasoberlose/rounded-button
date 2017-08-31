package com.tommasoberlose.roundedbutton

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: RoundedButton = findViewById(R.id.button)
        button.text.setText("CIAO")
        button.setProgressBarColor(android.R.color.white)
        button.setRounded(true)

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                button.setButtonLoading(!button.isButtonLoading())
            }
        })
    }
}
