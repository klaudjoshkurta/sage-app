package com.klaudjoshkurta.sage.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.sage.R

val Geist = FontFamily(
    Font(R.font.geist_light, FontWeight.Light),
    Font(R.font.geist_regular, FontWeight.Normal),
    Font(R.font.geist_medium, FontWeight.Medium),
    Font(R.font.geist_semibold, FontWeight.SemiBold),
    Font(R.font.geist_bold, FontWeight.Bold),
)

val GeistMono = FontFamily(
    Font(R.font.geistmono_regular, FontWeight.Normal),
    Font(R.font.geistmono_medium, FontWeight.Medium),
    Font(R.font.geistmono_semibold, FontWeight.SemiBold),
)

val baseline = Typography()

val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = Geist),
    displayMedium = baseline.displayMedium.copy(fontFamily = Geist),
    displaySmall = baseline.displaySmall.copy(fontFamily = Geist),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = Geist),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = Geist),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = Geist),
    titleLarge = baseline.titleLarge.copy(fontFamily = Geist),
    titleMedium = baseline.titleMedium.copy(fontFamily = Geist),
    titleSmall = baseline.titleSmall.copy(fontFamily = Geist),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = GeistMono),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = GeistMono),
    bodySmall = baseline.bodySmall.copy(fontFamily = GeistMono),
    labelLarge = baseline.labelLarge.copy(fontFamily = GeistMono),
    labelMedium = baseline.labelMedium.copy(fontFamily = GeistMono),
    labelSmall = baseline.labelSmall.copy(fontFamily = GeistMono),
)