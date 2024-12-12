package com.example.chian.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chian.R
import com.example.chian.component.ChianTopBar
import com.example.chian.ui.theme.chatBoxAccentTextColor
import com.example.chian.ui.theme.chatBoxBackColor
import com.example.chian.ui.theme.mainColor
import com.example.chian.ui.theme.mainHeadLineColor
import com.example.chian.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        ChianTopBar()
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 24.sp
                        )
                    ) {
                        append(text = "차량에 대해서 쉽게 알아봐요!")
                    }
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_eb)),
                    lineHeight = 20.sp,
                    color = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 17.sp,
                            color = mainColor
                        )
                    ) {
                        append("Chian")
                    }
                    append("의 특징 및 사용 방법이 뭔가요?")
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_b)),
                    color = mainHeadLineColor,
                    fontSize = 16.sp
                )
            )
            Box(
                modifier = Modifier
                    .border(1.dp, mainColor, RoundedCornerShape(12.dp))
                    .padding(18.dp)
            ) {
                Column {
                    Text(
                        text = buildAnnotatedString {
                            append("저희는 ")
                            withStyle(
                                SpanStyle(
                                    fontSize = 14.sp,
                                    color = chatBoxAccentTextColor
                                )
                            ) {
                                append("RAG ")
                            }
                            append("시스템을 활용한 챗봇을 통해 자동차의 성능에 대한 정보를 제공해요.\n\n")
                            append("일일이 하나씩 찾아 들어가지 않아도, ")
                            withStyle(
                                SpanStyle(
                                    fontSize = 14.sp,
                                    color = chatBoxAccentTextColor
                                )
                            ) {
                                append("챗봇")
                            }
                            append("을 통해 빠르게 정보를 얻을 수 있어요. \n\n")
                            append("처음 쓰시는 분도 ")
                            withStyle(
                                SpanStyle(
                                    fontSize = 14.sp,
                                    color = chatBoxAccentTextColor
                                )
                            ) {
                                append("아래 예시")
                            }
                            append("와 같이 사용하시면 편하게 이용 가능해요! \n\n")
                            append("같이 ")
                            withStyle(
                                SpanStyle(
                                    fontSize = 14.sp,
                                    color = chatBoxAccentTextColor
                                )
                            ) {
                                append("아래로 이동해서 ")
                            }
                            append("사용 방법을 볼까요?")
                        },
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                            color = Color.Black,
                            fontSize = 13.sp,
                            lineHeight = 16.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 17.sp,
                            color = mainColor
                        )
                    ) {
                        append("Chian")
                    }
                    append("의 사용 방법")
                },
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nanum_square_b)),
                    color = mainHeadLineColor,
                    fontSize = 16.sp
                )
            )

            ChatBotBox(
                modifier = Modifier,
                onClickListener = {
                    navHostController.navigate("chat")
                    mainViewModel.resetChatMessages()
                }
            )

            Row(
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Top),
                    text = "* ",
                    fontSize = 8.sp,
                    color = Color(0xFF666666)
                )
                Text(
                    text = "위의 예시를 통해 챗봇을 이용해 보세요.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                        color = Color(0xFF666666),
                        fontSize = 10.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

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
                            color = mainColor,
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
            .border(1.dp, mainColor, RoundedCornerShape(12.dp))
            .background(chatBoxBackColor)
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
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("챗봇") }
                            append("에게 빠르게 자동차의 ")
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("성능") }
                            append("에 대해서 ")
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("대화") }
                            append("를 해보실래요?\n\n")
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("차량명(모델명)") }
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
                        .background(mainColor)
                        .border(
                            1.dp,
                            mainColor,
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
                            color = Color(0xFF4C221A),
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
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("1. 평점: ") }
                            append("4.0/5\n\n")
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("2. 성능: ") }
                            append("쏘나타 DN8의 성능은 ...\n\n")
                            withStyle(SpanStyle(chatBoxAccentTextColor)) { append("3. 안전성: ") }
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
                            .background(mainColor)
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
