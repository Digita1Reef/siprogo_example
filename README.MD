# siprogo_example

This project is an implementation example of Siprogo.

# Index

* [Introduction](#introduction)
    * [Compilation and Prerequisites](#compilation-and-prerequisites)
* [Installation](#installation)
    * [settings.gradle](#settingsgradlekts--project-root-)
    * [build.gradle](#buildgradle--app-)
* [Quick Start](#quick-start-guide)
    * [Code Example](#code-example)
* [Themes](#themes)
    * [Code Example Theme](#code-example---theme)

## Introduction

Siprogo is a solution developed in [Kotlin](https://kotlinlang.org/) that facilitates the
distribution and customization of content, requiring only the importation, resolution of
dependencies, and implementation of resources.

## Compilation and Prerequisites

To access the artifacts, you need to have an `authentication token`
on [Jitpack](https://jitpack.io/), as well as the `secretKey` of your organizations.

Siprogo is compiled with the following parameters:

```
android{
    compileSdk = 34
    ...    
        defaultConfig {
            minSdk = 21
            ...
        }
        
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.3"
        }
        ...
```

## Installation

Access to the library is via [Jitpack](https://jitpack.io/) and should be added to the dependencies
and assembly of the project/application.

### settings.gradle.kts (project root)

``` 
    dependencyResolutionManagement {
    ...
    maven {
        url = uri("https://jitpack.io")
        credentials {
            username = "YOUR_TOKEN"
        }
    }
    ...
    
```

### build.gradle (app)

```
dependencies {
    implementation ("com.github.Digita1Reef.siprogo:sdk:[tag]")
    ...
}
```

## Quick Start Guide

Once the imports are done and the project is synchronized, various packages become available for
partial or total implementation of the resources.

For a robust implementation, it's recommended to create an instance of `SDKImplementation` in
your `Application` class using the `SiprogoSdkProvider`. This ensures that the SDK instance isn't
recreated on each render or live edit, maintaining optimal performance and resource management.

Implement the `SDKImplementation` method contained in the `com.siprocal.siprogo.sdk` package with
the following constructor:

```
SDKImplementation (
    context: android.content.Context, 
    secretKey: kotlin.String,
    theme: SiprogoThemeDefinition?
)  
```

### Code Example

The implementation at the Application level is exemplified below, with `MainActivity` using the SDK
instance.

```kotlin
//SiprogoSdkProvider.kt
object SiprogoSdkProvider {
    lateinit var sdk: SDKImplementation
        private set

    fun initialize(
        context: Context,
        secretKey: String,
        theme: SiprogoThemeDefinition? = null
    ) {
        sdk = SDKImplementation(
            context = context,
            secretKey = secretKey,
            theme = theme
        )
    }
}
```

```kotlin
// MainApplication.kt
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
```

```kotlin
// MainActivity.kt
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
```

## Implementation Note on SiprogoSdkProvider

In this implementation example, we have utilized the `SiprogoSdkProvider` to manage the instance of
the Siprogo SDK. The `SiprogoSdkProvider` is initialized in the `Application` class of the Android
project, ensuring that the SDK is maintained as a singleton instance throughout the app's lifecycle.
This approach is adopted to prevent unnecessary re-creation of the SDK during runtime, thereby
optimizing performance and resource management. It’s an effective pattern for ensuring that the SDK
remains available and consistent across different components of the application.

The implementation above shows the screen result for the `1.0.2-release` version of the SDK.

![screen_basic.png](./images/screen_basic.png)

## Themes

An optional argument in the SDKImplementation implementation is the Theme. In it, it's possible to
adapt to each implementation reality.

### Code Example - Theme

#### MainActivity

```kotlin
// MainActivity.kt with theme
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
```

#### ExampleTheme

```
object ExampleTheme : SiprogoThemeDefinition {
    override val colors: SiprogoThemeColors = ExampleThemeColors
    override val fonts: SiprogoThemeFonts = ExampleThemeFonts
}
```

#### ExampleThemeColors

```
import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeColors

object ExampleThemeColors : SiprogoThemeColors {
    override val primary: Color = Color(0xFF3E63DD)
    override val onPrimary: Color = Color(0xFFFAF9F7)

    override val secondary: Color = Color(0xFF2D2D2D)
    override val onSecondary: Color = Color(0xFFFAF9F7)

    override val background: Color = Color(0xFF1F1F1F)
    override val onBackground: Color = Color(0xFFFFFFFF)

    override val surface: Color = Color(0xFF2D2D2D)
    override val onSurface: Color = Color(0xFFFAF9F7)

    override val error: Color = Color(0xFFE5484D)
    override val onError: Color = Color(0xFFFAF9F7)

    override val neutral: Color = Color(0x1AFFFFFF)
    override val onNeutral: Color = Color(0xFFA8A8A8)

}

```

#### ExampleThemeFonts

```
import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeFonts

object ExampleThemeFonts : SiprogoThemeFonts {

    private val displayFontName = GoogleFont("Sora")
    private val fontProvider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    override val displayFontFamily: FontFamily =
        FontFamily(
            Font(
                googleFont = displayFontName, fontProvider =
                    fontProvider
            )
        )

    private val otherFontName = GoogleFont("Archivo")
    override val otherFontFamily: FontFamily =
        FontFamily(
            Font(
                googleFont = otherFontName,
                fontProvider = fontProvider
            )
        )

}

```

#### Example applying a custom theme

![screen_theme.png](./images/screen_theme.png)