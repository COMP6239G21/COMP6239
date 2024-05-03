package com.edu.demo.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.edu.demo.R
import com.edu.demo.RouteConfig
import com.edu.demo.db.DbManager
import com.edu.demo.ui.theme.Blue1
import com.edu.demo.ui.theme.Blue2
import com.edu.demo.ui.theme.Purple40

/**
 * 主页面
 */

@Preview(showBackground = true)
@Composable
fun PreviewMainPage() {
    MainPage(name = "TTX", position = "5")
}

@Composable
fun MainPage(name: String?, position: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dp(100f))
    ) {

        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = "aaa",
            modifier = Modifier
                .size(Dp(240f))
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(Dp(10f)))
        Text(
            text = "Welcome $name",
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .align(Alignment.CenterHorizontally),
            fontSize = TextUnit(20f, TextUnitType.Sp),
            color = Blue2
        )
        Spacer(modifier = Modifier.height(Dp(20f)))


        Spacer(modifier = Modifier.height(Dp(40f)))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    //返回登陆页面
                    NavUtil.get().back()
                },colors = ButtonDefaults.buttonColors(
                    containerColor = Blue1 // 使用导入的颜色
                )
            ) {
                Text(
                    text = "Exit",
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}
