package com.example.myapplication.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.myapplication.R
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
