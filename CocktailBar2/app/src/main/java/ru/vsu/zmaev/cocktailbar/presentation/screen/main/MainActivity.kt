package ru.vsu.zmaev.cocktailbar.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigator
import ru.vsu.zmaev.cocktailbar.App
import ru.vsu.zmaev.cocktailbar.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
    }

    private fun inject() {
        (applicationContext as App).appComponent.inject(this)
    }
}
