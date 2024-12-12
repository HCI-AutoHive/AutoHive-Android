package com.example.chian.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chian.R
import com.example.chian.ui.theme.mainColor
import com.example.chian.ui.theme.textFieldBackGroundColor
import com.example.chian.ui.theme.textFieldIconColor

@Composable
fun ChianTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onSendClick: () -> Unit = {},
    interactionSource: MutableInteractionSource,
    isLoading: Boolean = false
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp)
            .height(45.dp),
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, textFieldBackGroundColor, RoundedCornerShape(8.dp))
                .background(textFieldBackGroundColor),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                value = value,
                onValueChange = {
                    onValueChange(it) // 실시간으로 강조 적용
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.nanum_square_r)),
                    fontSize = 18.sp
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        innerTextField()
                    }
                }
            )
            Icon(
                modifier = Modifier
                    .padding(end = 14.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        enabled = value.isNotBlank() && !isLoading
                    ) {
                        onSendClick()
                        onValueChange("")
                    },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_send_24),
                contentDescription = "보내기 아이콘",
                tint = if (isLoading) Color.LightGray else mainColor
            )
        }
    }
}