package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.ExampleTheme
import com.siprocal.siprogo.sdk.SDKImplementation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
fun MainActivityContent() {
    SiprogoSdkProvider.sdk.renderApp(enabledBottomNavigation = false)
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    MainActivityContent()
}