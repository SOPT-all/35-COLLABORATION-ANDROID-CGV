package org.sopt.cgv.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.sopt.cgv.R

val koPubDotumFontFamily = FontFamily(
    Font(resId = R.font.kopub_world_dotum_bold, weight = FontWeight.Bold),
    Font(resId = R.font.kopub_world_dotum_medium, weight = FontWeight.Medium),
    Font(resId = R.font.kopub_world_dotum_light, weight = FontWeight.Light)
)

val malgunGothicFontFamily = FontFamily(
    Font(resId = R.font.malgun_gothic_bold, weight = FontWeight.Bold),
    Font(resId = R.font.malgun_gothic_regular, weight = FontWeight.Normal)
)
// Set of Material typography styles to start with
internal val Typography = CGVTypography(
    koPubDotumHead8 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumHead7 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumHead6 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumHead5 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumHead4 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumHead3 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumHead2 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumHead1 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumHead0 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumBody4 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumBody3 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumBody2 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumBody1 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    koPubDotumBody0 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumSmall1 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    koPubDotumSmall0 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    ),
    malgunGothicHead3 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgunGothicHead2 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgunGothicHead1 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    malgunGothicHead0 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgunGothicBody3 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    malgunGothicBody2 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    malgunGothicBody1 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    malgunGothicBody0 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )
)

@Immutable
data class CGVTypography(
    val koPubDotumHead8: TextStyle,
    val koPubDotumHead7: TextStyle,
    val koPubDotumHead6: TextStyle,
    val koPubDotumHead5: TextStyle,
    val koPubDotumHead4: TextStyle,
    val koPubDotumHead3: TextStyle,
    val koPubDotumHead2: TextStyle,
    val koPubDotumHead1: TextStyle,
    val koPubDotumHead0: TextStyle,
    val koPubDotumBody4: TextStyle,
    val koPubDotumBody3: TextStyle,
    val koPubDotumBody2: TextStyle,
    val koPubDotumBody1: TextStyle,
    val koPubDotumBody0: TextStyle,
    val koPubDotumSmall1: TextStyle,
    val koPubDotumSmall0: TextStyle,
    val malgunGothicHead3: TextStyle,
    val malgunGothicHead2: TextStyle,
    val malgunGothicHead1: TextStyle,
    val malgunGothicHead0: TextStyle,
    val malgunGothicBody3: TextStyle,
    val malgunGothicBody2: TextStyle,
    val malgunGothicBody1: TextStyle,
    val malgunGothicBody0: TextStyle,
)

val LocalCGVTypography = staticCompositionLocalOf {
    CGVTypography(
        koPubDotumHead8 = TextStyle.Default,
        koPubDotumHead7 = TextStyle.Default,
        koPubDotumHead6 = TextStyle.Default,
        koPubDotumHead5 = TextStyle.Default,
        koPubDotumHead4 = TextStyle.Default,
        koPubDotumHead3 = TextStyle.Default,
        koPubDotumHead2 = TextStyle.Default,
        koPubDotumHead1 = TextStyle.Default,
        koPubDotumHead0 = TextStyle.Default,
        koPubDotumBody4 = TextStyle.Default,
        koPubDotumBody3 = TextStyle.Default,
        koPubDotumBody2 = TextStyle.Default,
        koPubDotumBody1 = TextStyle.Default,
        koPubDotumBody0 = TextStyle.Default,
        koPubDotumSmall1 = TextStyle.Default,
        koPubDotumSmall0 = TextStyle.Default,
        malgunGothicHead3 = TextStyle.Default,
        malgunGothicHead2 = TextStyle.Default,
        malgunGothicHead1 = TextStyle.Default,
        malgunGothicHead0 = TextStyle.Default,
        malgunGothicBody3 = TextStyle.Default,
        malgunGothicBody2 = TextStyle.Default,
        malgunGothicBody1 = TextStyle.Default,
        malgunGothicBody0 = TextStyle.Default
    )
}