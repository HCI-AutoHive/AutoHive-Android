package com.example.chian.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chian.R
import com.example.chian.component.ChianTopBar
import com.example.chian.ui.theme.mainBlueColor
import com.example.chian.ui.theme.mainHeadLineColor
import com.example.chian.ui.theme.textFieldBackGroundColor
import com.example.chian.ui.theme.textYellowColor

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        ChianTopBar()
        Column {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 24.sp
                        )
                    ) {
                        append(text = "차량에 대해서 알아가기 어려우시죠?")
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp
                        )
                    ) {
                        append(text = "\n저희 Chian을 통해 쉽게 알아가봐요.")
                    }
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                    lineHeight = 20.sp
                )
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Top),
                    text = "* ",
                    fontSize = 8.sp,
                    color = Color(0xFF666666)
                )
                Text(
                    text = "아래 예시를 통해 챗봇을 이용해 보세요.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                        color = Color(0xFF666666),
                        fontSize = 10.sp
                    )
                )
            }

            ChatBotBox(
                modifier = Modifier,
                onClickListener = {}
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp
                        )
                    ) {
                        append("해당 서비스를 이용하고 싶으시면 ")
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 18.sp,
                            color = mainBlueColor,
                            fontFamily = FontFamily(Font(R.font.nanum_square_b))
                        )
                    ) {
                        append("전송")
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 16.sp
                        )
                    ) {
                        append(" 버튼을 눌러 주세요!")
                    }
                },
                fontFamily = FontFamily(Font(R.font.nanum_square_b)),
                color = mainHeadLineColor,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

        }

    }
}

@Composable
private fun ChatBotBox(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, mainBlueColor, RoundedCornerShape(12.dp))
            .background(textFieldBackGroundColor)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 2.dp,
                                topEnd = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .background(Color.White)
                        .border(
                            1.dp,
                            Color.White,
                            RoundedCornerShape(
                                topStart = 2.dp,
                                topEnd = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .padding(vertical = 14.dp, horizontal = 22.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("AI 기반의 ")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("챗봇") }
                            append("에게 빠르게 자동차의 ")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("성능") }
                            append("에 대해서 ")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("대화") }
                            append("를 해보실래요?\n")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("차량명(모델명)") }
                            append("만 작성해 주시면 됩니다.")
                        },
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp)
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 2.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .background(mainBlueColor)
                        .border(
                            1.dp,
                            mainBlueColor,
                            RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 2.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .padding(vertical = 14.dp, horizontal = 22.dp)
                ) {
                    Text(
                        text = "쏘나타 DN8",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            color = textYellowColor,
                            fontSize = 14.sp
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 2.dp,
                                topEnd = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .background(Color.White)
                        .border(
                            1.dp,
                            Color.White,
                            RoundedCornerShape(
                                topStart = 2.dp,
                                topEnd = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .padding(vertical = 14.dp, horizontal = 22.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(color = mainBlueColor)) { append("1. 평점: ") }
                            append("4.0/5\n\n")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("2. 성능: ") }
                            append("쏘나타 DN8의 성능은 ...\n\n")
                            withStyle(SpanStyle(color = mainBlueColor)) { append("3. 안전성: ") }
                            append(" 쏘나타 DN8은 견고한 플랫폼 설계와 ... ")
                        },
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFFFFFFF))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 13.dp),
                        text = "너무 너무 궁금해요. 이용해 보고 싶어요!",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )

                    Box(
                        modifier = Modifier
                            .width(78.dp)
                            .fillMaxHeight()
                            .background(mainBlueColor)
                            .clickable {
                                onClickListener()
                            }
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "전송",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}