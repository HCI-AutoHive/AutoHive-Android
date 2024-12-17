package com.example.chian.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.chian.R
import com.example.chian.component.ChianTopBar
import com.example.chian.ui.theme.chatBoxBackColor
import com.example.chian.ui.theme.mainColor
import com.example.chian.viewmodel.MainViewModel

@Composable
fun DetailsMainScreen(
    mainViewModel: MainViewModel,
    navHostController: NavHostController
) {
    val carsData = mainViewModel.carsData.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ChianTopBar()

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "직접 찾아서 볼 수도 있어요!",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                lineHeight = 20.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(carsData.value.size) {
                DetailBox(
                    modifier = Modifier.clickable {
                        mainViewModel.getCurrentCarId(carsData.value[it].carId)
                        mainViewModel.getCarDetailData()
                        mainViewModel.gutterCarNameImageData(
                            carsData.value[it].model,
                            carsData.value[it].imageUrl
                        )
                        navHostController.navigate("details")
                    },
                    carName = carsData.value[it].model,
                    star = carsData.value[it].starRating,
                    imageUrl = carsData.value[it].imageUrl
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(chatBoxBackColor)
                )
            }
        }
    }
}

@Composable
fun DetailBox(
    modifier: Modifier,
    carName: String,
    star: Double,
    imageUrl: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Transparent)
                .border(1.dp, mainColor, RoundedCornerShape(12.dp))
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = imageUrl,
                contentDescription = "차량 이미지",
                contentScale = ContentScale.Inside
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = carName,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_b)),
                    fontSize = 15.sp
                )
            )
            /* 종합 평점 : $star / 5 */
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = mainColor)) {
                        append("종합 평점")
                    }
                    append(" : $star / 5")
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_b)),
                    fontSize = 15.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailBoxPreview() {
    val navHostController = NavHostController(
        context = LocalContext.current
    )
    DetailsMainScreen(
        mainViewModel = MainViewModel(),
        navHostController = navHostController
    )
}