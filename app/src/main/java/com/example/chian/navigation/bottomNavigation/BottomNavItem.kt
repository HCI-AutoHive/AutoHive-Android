package com.example.chian.navigation.bottomNavigation

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.chian.R
import com.example.chian.navigation.Route
import com.example.chian.ui.theme.iconSelctedColor
import com.example.chian.ui.theme.iconUnselectedColor

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: @Composable (Boolean) -> Unit
) {
    object ChatScreen : BottomNavItem(Route.CHAT, "챗봇", { isSelect ->
        if (isSelect) {
            Icon(
               imageVector = ImageVector.vectorResource(id = R.drawable.ic_chat),
                contentDescription = "챗봇 아이콘",
                tint = iconSelctedColor
            )
        } else {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_chat),
                contentDescription = "챗봇 아이콘",
                tint = iconUnselectedColor
            )
        }
    })

    object HomeScreen : BottomNavItem(Route.HOME, "홈", { isSelect ->
        if (isSelect) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
                contentDescription = "리뷰 아이콘",
                tint = iconSelctedColor
            )
        } else {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
                contentDescription = "리뷰 아이콘",
                tint = iconUnselectedColor
            )
        }
    })

    object DetailMainScreen : BottomNavItem(Route.DETAILS_MAIN, "정보", { isSelect ->
        if (isSelect) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_stocks),
                contentDescription = "홈 아이콘",
                tint = iconSelctedColor
            )
        } else {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_stocks),
                contentDescription = "홈 아이콘",
                tint = iconUnselectedColor
            )
        }
    })
}