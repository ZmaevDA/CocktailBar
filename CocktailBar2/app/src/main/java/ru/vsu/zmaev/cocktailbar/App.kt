package ru.vsu.zmaev.cocktailbar

import android.app.Application
import ru.vsu.zmaev.cocktailbar.di.AppComponent
import ru.vsu.zmaev.cocktailbar.di.AppModule
import ru.vsu.zmaev.cocktailbar.di.DaggerAppComponent

open class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule((this)))
            .build()
    }
}