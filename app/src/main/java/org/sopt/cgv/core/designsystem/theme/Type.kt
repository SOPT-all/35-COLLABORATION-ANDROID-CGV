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
    kopub_dotum_head8_b_20 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head7_b_18 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head6_b_17 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head5_b_16 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head4_b_15 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head3_b_14 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head2_b_13 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head1_b_12 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_head0_b_10 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_body4_m_15 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_body3_m_14 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_body2_m_13 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_body1_m_12 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    kopub_dotum_body0_m_11 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_small1_l_10 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    kopub_dotum_small0_l_8 = TextStyle(
        fontFamily = koPubDotumFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    ),
    malgun_gothic_head3_b_20 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgun_gothic_head2_b_18 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgun_gothic_head1_b_16 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    malgun_gothic_head0_b_11 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    malgun_gothic_body3_r_18 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    malgun_gothic_body2_r_12 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    malgun_gothic_body1_r_10 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.sp
    ),
    malgun_gothic_body0_r_8 = TextStyle(
        fontFamily = malgunGothicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    )
)

@Immutable
data class CGVTypography(
    val kopub_dotum_head8_b_20: TextStyle,
    val kopub_dotum_head7_b_18: TextStyle,
    val kopub_dotum_head6_b_17: TextStyle,
    val kopub_dotum_head5_b_16: TextStyle,
    val kopub_dotum_head4_b_15: TextStyle,
    val kopub_dotum_head3_b_14: TextStyle,
    val kopub_dotum_head2_b_13: TextStyle,
    val kopub_dotum_head1_b_12: TextStyle,
    val kopub_dotum_head0_b_10: TextStyle,
    val kopub_dotum_body4_m_15: TextStyle,
    val kopub_dotum_body3_m_14: TextStyle,
    val kopub_dotum_body2_m_13: TextStyle,
    val kopub_dotum_body1_m_12: TextStyle,
    val kopub_dotum_body0_m_11: TextStyle,
    val kopub_dotum_small1_l_10: TextStyle,
    val kopub_dotum_small0_l_8: TextStyle,
    val malgun_gothic_head3_b_20: TextStyle,
    val malgun_gothic_head2_b_18: TextStyle,
    val malgun_gothic_head1_b_16: TextStyle,
    val malgun_gothic_head0_b_11: TextStyle,
    val malgun_gothic_body3_r_18: TextStyle,
    val malgun_gothic_body2_r_12: TextStyle,
    val malgun_gothic_body1_r_10: TextStyle,
    val malgun_gothic_body0_r_8: TextStyle,
)

val LocalCGVTypography = staticCompositionLocalOf {
    CGVTypography(
        kopub_dotum_head8_b_20 = TextStyle.Default,
        kopub_dotum_head7_b_18 = TextStyle.Default,
        kopub_dotum_head6_b_17 = TextStyle.Default,
        kopub_dotum_head5_b_16 = TextStyle.Default,
        kopub_dotum_head4_b_15 = TextStyle.Default,
        kopub_dotum_head3_b_14 = TextStyle.Default,
        kopub_dotum_head2_b_13 = TextStyle.Default,
        kopub_dotum_head1_b_12 = TextStyle.Default,
        kopub_dotum_head0_b_10 = TextStyle.Default,
        kopub_dotum_body4_m_15 = TextStyle.Default,
        kopub_dotum_body3_m_14 = TextStyle.Default,
        kopub_dotum_body2_m_13 = TextStyle.Default,
        kopub_dotum_body1_m_12 = TextStyle.Default,
        kopub_dotum_body0_m_11 = TextStyle.Default,
        kopub_dotum_small1_l_10 = TextStyle.Default,
        kopub_dotum_small0_l_8 = TextStyle.Default,
        malgun_gothic_head3_b_20 = TextStyle.Default,
        malgun_gothic_head2_b_18 = TextStyle.Default,
        malgun_gothic_head1_b_16 = TextStyle.Default,
        malgun_gothic_head0_b_11 = TextStyle.Default,
        malgun_gothic_body3_r_18 = TextStyle.Default,
        malgun_gothic_body2_r_12 = TextStyle.Default,
        malgun_gothic_body1_r_10 = TextStyle.Default,
        malgun_gothic_body0_r_8 = TextStyle.Default
    )
}