package ru.eyelog.severalfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: AwesomeViewModel by viewModels {
        AwesomeViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.tapButton)


        supportFragmentManager
            .beginTransaction()
            .add(R.id.firstFragment, FirstFragment.newInstance())
            .add(R.id.secondFragment, SecondFragment.newInstance())
            .add(R.id.thirdFragment, ThirdFragment.newInstance())
            .add(R.id.fourthFragment, FourthFragment.newInstance())
            .commit()

        button.setOnClickListener {
            viewModel.buttonClicked()
        }
    }
}