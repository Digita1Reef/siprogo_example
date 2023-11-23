package com.example.myapplication.ui.theme

import androidx.compose.ui.graphics.Color
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
