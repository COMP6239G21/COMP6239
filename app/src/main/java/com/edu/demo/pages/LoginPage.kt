package com.edu.demo.pages

import android.text.TextUtils
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.edu.demo.R
import com.edu.demo.RouteConfig
import com.edu.demo.util.Utils
import com.edu.demo.db.DbManager
import com.edu.demo.ui.theme.Blue1

/**
 * 登陆页面
 */
@Preview
@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = Dp(100f))
    ) {
        var userName by remember { mutableStateOf("") }
        var userPwd by remember { mutableStateOf("") }
        var selectedRole by remember { mutableStateOf("Reader") } // 默认选择读者

        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = "aaa",
            modifier = Modifier
                .size(Dp(120f))
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(Dp(8f)))
        Text(
            text = "Welcome",
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .align(Alignment.CenterHorizontally),
            fontSize = TextUnit(20f, TextUnitType.Sp),
            color = Color(0xFF00796B)
        )

        Spacer(modifier = Modifier.height(Dp(20f)))

        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            TextField(
                value = userName,
                onValueChange = {
                    userName = it
                },
                modifier = Modifier
                    .background(Color.Transparent),
                label = {
                    Text(text = "Name or E-mail")
                },
                singleLine = true,
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_circle_account), contentDescription = "")
                },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }

        Spacer(modifier = Modifier.height(Dp(20f)))
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            var passwordHidden by remember { mutableStateOf(true) }
            TextField(
                value = userPwd,
                onValueChange = {
                    userPwd = it
                },
                modifier = Modifier
                    .background(Color.White, CircleShape),
                shape = RoundedCornerShape(20.dp),
                label = {
                    Text(text = "Password")
                },
                singleLine = true,
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_lock), contentDescription = "")
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordHidden = !passwordHidden
                        }

                    ) {
                        Icon(
                            painterResource(id = R.drawable.ui_view_pwd), null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None
            )
        }

        Spacer(modifier = Modifier.height(Dp(20f)))
        // 添加选择按钮
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            RadioButton(
                selected = selectedRole == "Author",
                onClick = { selectedRole = "Author" }
            )
            Text(text = "Author", modifier = Modifier.align(Alignment.CenterVertically))
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = selectedRole == "Reader",
                onClick = { selectedRole = "Reader" }
            )
            Text(text = "Reader", modifier = Modifier.align(Alignment.CenterVertically))
        }

        Spacer(modifier = Modifier.height(Dp(40f)))
        Button(
            onClick = {
                // 点击事件回调
                if (TextUtils.isEmpty(userName)) {
                    Log.d("ttx", "ShowBaseView: empty name")
                    Utils.get().toast("empty name")
                    return@Button
                }
                if (TextUtils.isEmpty(userPwd)) {
                    Log.d("ttx", "ShowBaseView: empty pwd")
                    Utils.get().toast("empty pwd")
                    return@Button
                }
                val user = DbManager.get().queryUser(userName, userName)
                Log.d("ttx", "LoginPage: " + user?.toString())
                if (user == null) {
                    Log.d("ttx", "ShowBaseView: user not exit")
                    Utils.get().toast("user not exit")
                } else {
                    if (user.pwd.equals(Utils.get().getMD5Hash(userPwd))) {
                        Utils.get().toast("login success")
                        var tempName = userName
                        if (!TextUtils.isEmpty(user.name)) {
                            tempName = user.name!!
                        }
                        val targetPage = if (selectedRole == "Author") RouteConfig.MAIN_PAGE else RouteConfig.MAIN_PAGE
                        NavUtil.get()
                            .navigation(
                                targetPage,
                                params = hashMapOf(
                                    Pair("name", tempName),
                                    Pair("id", user.id.toString())
                                )
                            )
                    } else {
                        Utils.get().toast("pwd error")
                    }
                }
            },
            Modifier
                .width(160.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Blue1)
        ) {
            Text(text = "Login", fontSize = TextUnit(20f, TextUnitType.Sp))
        }
        Spacer(modifier = Modifier.height(Dp(10f)))
        ClickableText(
            text = AnnotatedString("register"),
            onClick = {
                NavUtil.get().navigation(RouteConfig.REGISTER_PAGE)
            },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = TextUnit(16f, TextUnitType.Sp),
                color = Color.Black,
                textDecoration = TextDecoration.Underline,
            ),
        )
    }
}

