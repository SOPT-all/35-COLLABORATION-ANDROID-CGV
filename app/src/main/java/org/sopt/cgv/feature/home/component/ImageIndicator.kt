package org.sopt.cgv.feature.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.cgv.R
import org.sopt.cgv.core.designsystem.theme.Gray400
import org.sopt.cgv.core.designsystem.theme.Gray700


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageIndicator(
    modifier: Modifier,
    images: PersistentList<Int>
) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                pageSpacing = 8.dp
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(24.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(images.size) { index ->
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (index == pagerState.currentPage) Gray700 else Gray400,
                                    shape = CircleShape
                                )
                        )
                    }
                }

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_share),
                    contentDescription = "share",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageIndicator() {
    val sampleImages = persistentListOf(
        R.drawable.img_home_imax1,
        R.drawable.img_home_imax2,
        R.drawable.img_home_imax3,
        R.drawable.img_home_imax4
    )
    ImageIndicator(
        modifier = Modifier,
        images = sampleImages
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewImageIndicator2() {
    val sampleImages = persistentListOf(
        R.drawable.img_home_hot1,
        R.drawable.img_home_hot2,
        R.drawable.img_home_hot3,
        R.drawable.img_home_hot4
    )
    ImageIndicator(
        modifier = Modifier,
        images = sampleImages
    )
}
