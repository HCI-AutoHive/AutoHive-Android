package com.example.chian.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chian.R
import com.example.chian.component.ChianTopBar
import com.example.chian.viewmodel.MainViewModel

@Composable
fun DetailsScreen(
    mainViewModel: MainViewModel,
    navHostController: NavHostController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChianTopBar()

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "차량 상세 정보",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                lineHeight = 20.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Red)
            ){

            }

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "차량명",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.nanum_square_eb))
                )
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                            fontSize = 20.sp,
                        )
                    ){
                        append("[성능]")
                    }

                    withStyle(
                        SpanStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            fontSize = 15.sp,
                            baselineShift = BaselineShift.Subscript
                        )
                    ){
                        append("\n차량의 성능은 뭐시기 어쩌구 어쩌구 차가 좋을까 안좋을까? 몰라~")
                    }
                },
                color = Color.Black,
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                            fontSize = 20.sp,
                        )
                    ){
                        append("[안전]")
                    }
                    withStyle(
                        SpanStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            fontSize = 15.sp,
                            baselineShift = BaselineShift.Subscript
                        )
                    ){
                        append("\n차량의 안전은 뭐시기 어쩌구 어쩌구 차가 좋을까 안좋을까? 몰라~")
                    }
                },
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailsScreen() {
    val navHostController = NavHostController(
        context = LocalContext.current
    )
    DetailsScreen(
        mainViewModel = MainViewModel(),
        navHostController = navHostController
    )
}