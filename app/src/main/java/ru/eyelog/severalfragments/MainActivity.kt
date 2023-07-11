package ru.eyelog.severalfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import ru.eyelog.severalfragments.di.DaggerVMComponent
import ru.eyelog.severalfragments.di.VMComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: AwesomeViewModel

    private lateinit var component: VMComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = DaggerVMComponent.create()
        component.inject(this)

        val button = findViewById<Button>(R.id.tapButton)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.firstFragment, FirstFragment.newInstance())
            .add(R.id.secondFragment, SecondFragment.newInstance())
            .add(R.id.thirdFragment, ThirdFragment.newInstance())
            .add(R.id.fourthFragment, FourthFragment.newInstance())
            .commit()

        Log.i("Logcat", viewModel.toString())

        button.setOnClickListener {
            viewModel.buttonClicked()
        }
    }

    fun injectFragment(fragment: FirstFragment){
        component.inject(fragment)
    }

    fun injectFragment(fragment: SecondFragment){
        component.inject(fragment)
    }

    fun injectFragment(fragment: ThirdFragment){
        component.inject(fragment)
    }

    fun injectFragment(fragment: FourthFragment){
        component.inject(fragment)
    }
}