package com.example.myapplication.ui.theme

import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeColors
import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeDefinition
import com.siprocal.siprogo.sdk_contracts.theme.SiprogoThemeFonts

object ExampleTheme : SiprogoThemeDefinition {
    override val colors: SiprogoThemeColors = ExampleThemeColors
    override val fonts: SiprogoThemeFonts = ExampleThemeFonts
}