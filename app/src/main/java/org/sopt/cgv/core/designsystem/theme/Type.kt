package org.sopt.cgv.core.designsystem.theme

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
    head8_b_20 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head7_b_18 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    head6_b_17 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    head5_b_16 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head4_b_15 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head3_b_14 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    head2_b_13 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    head1_b_12 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    head0_b_10 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body4_m_15 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body3_m_14 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    body2_m_13 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    body1_m_12 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    body0_m_11 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    small1_l_10 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    small0_l_8 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    ),
    head3_b_20 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head2_b_18 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head1_b_16 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    head0_b_11 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body3_r_18 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    body2_r_12 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    body1_r_10 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    body0_r_8 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )
)

@Immutable
data class CGVTypography(
    val head8_b_20: TextStyle,
    val head7_b_18: TextStyle,
    val head6_b_17: TextStyle,
    val head5_b_16: TextStyle,
    val head4_b_15: TextStyle,
    val head3_b_14: TextStyle,
    val head2_b_13: TextStyle,
    val head1_b_12: TextStyle,
    val head0_b_10: TextStyle,
    val body4_m_15: TextStyle,
    val body3_m_14: TextStyle,
    val body2_m_13: TextStyle,
    val body1_m_12: TextStyle,
    val body0_m_11: TextStyle,
    val small1_l_10: TextStyle,
    val small0_l_8: TextStyle,
    val head3_b_20: TextStyle,
    val head2_b_18: TextStyle,
    val head1_b_16: TextStyle,
    val head0_b_11: TextStyle,
    val body3_r_18: TextStyle,
    val body2_r_12: TextStyle,
    val body1_r_10: TextStyle,
    val body0_r_8: TextStyle,
)

val LocalCGVTypography = staticCompositionLocalOf {
    CGVTypography(
        head8_b_20 = TextStyle.Default,
        head7_b_18 = TextStyle.Default,
        head6_b_17 = TextStyle.Default,
        head5_b_16 = TextStyle.Default,
        head4_b_15 = TextStyle.Default,
        head3_b_14 = TextStyle.Default,
        head2_b_13 = TextStyle.Default,
        head1_b_12 = TextStyle.Default,
        head0_b_10 = TextStyle.Default,
        body4_m_15 = TextStyle.Default,
        body3_m_14 = TextStyle.Default,
        body2_m_13 = TextStyle.Default,
        body1_m_12 = TextStyle.Default,
        body0_m_11 = TextStyle.Default,
        small1_l_10 = TextStyle.Default,
        small0_l_8 = TextStyle.Default,
        head3_b_20 = TextStyle.Default,
        head2_b_18 = TextStyle.Default,
        head1_b_16 = TextStyle.Default,
        head0_b_11 = TextStyle.Default,
        body3_r_18 = TextStyle.Default,
        body2_r_12 = TextStyle.Default,
        body1_r_10 = TextStyle.Default,
        body0_r_8 = TextStyle.Default
    )
}