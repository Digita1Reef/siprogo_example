package com.example.myapplication

import android.content.Context
import com.siprocal.siprogo.sdk.SDKImplementation
import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeDefinition

object SiprogoSdkProvider {
    lateinit var sdk: SDKImplementation
        private set

    fun initialize(context: Context, theme: SiprogoThemeDefinition, secretKey: String) {
        sdk = SDKImplementation(context, theme, secretKey)
    }
}