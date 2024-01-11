package com.example.myapplication

import android.app.Application
import com.example.myapplication.ui.theme.ExampleTheme

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SiprogoSdkProvider.initialize(
            context = this,
            theme = ExampleTheme,
            secretKey = BuildConfig.SECRET_KEY
        )
    }
}