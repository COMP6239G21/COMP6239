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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.edu.demo.R
import com.edu.demo.RouteConfig
import com.edu.demo.util.Utils
import com.edu.demo.db.DbManager
import com.edu.demo.db.UserBean
import com.edu.demo.ui.theme.Blue1
import com.edu.demo.ui.theme.Blue2

/**
 * 注册页面
 */
@Preview
@Composable
fun RegisterPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = Dp(100f))
    ) {
        var text by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var pwd by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = "aaa",
            modifier = Modifier
                .size(Dp(120f))
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(Dp(8f)))
        Text(
            text = "Register",
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .align(Alignment.CenterHorizontally),
            fontSize = TextUnit(20f, TextUnitType.Sp),
            color = Blue2
        )

        Spacer(modifier = Modifier.height(Dp(20f)))
        //name 输入
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // 去除焦点状态下的线条
                    unfocusedIndicatorColor = Color.Transparent // 去除非焦点状态下的线条
                ),
                modifier = Modifier
                    .background(Color.Transparent),
                label = {
                    Text(text = "Name")
                },
                singleLine = true,
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_circle_account), contentDescription = "")
                }
            )
        }
        Spacer(modifier = Modifier.height(Dp(20f)))
        //phone输入框
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .background(Color.Transparent),
                label = {
                    Text(text = "Email")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // 去除焦点状态下的线条
                    unfocusedIndicatorColor = Color.Transparent // 去除非焦点状态下的线条
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_email), contentDescription = "")
                }
            )
        }
        Spacer(modifier = Modifier.height(Dp(20f)))
        //密码输入框
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        ) {
            var passwordHidden by remember { mutableStateOf(true) }

            TextField(
                value = pwd,
                onValueChange = {
                    pwd = it
                },
                modifier = Modifier
                    .background(Color.White, CircleShape),
                label = {
                    Text(text = "Password")
                },
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // 去除焦点状态下的线条
                    unfocusedIndicatorColor = Color.Transparent, // 去除非焦点状态下的线条\
                ),
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
                        Icon(painterResource(id = R.drawable.ui_view_pwd), null)
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None
            )
        }
        Spacer(modifier = Modifier.height(Dp(40f)))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            //返回
            Button(
                onClick = {
                    NavUtil.get().back()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue1 // 使用导入的颜色
                )
            ) {
                Text(text = "Back", fontSize = TextUnit(20f, TextUnitType.Sp))
            }
            //注册
            Button(
                onClick = {
                    if (TextUtils.isEmpty(text)) {
                        Log.d("ttx", "ShowBaseView: empty name")
                        Utils.get().toast("empty name")
                        return@Button
                    }
                    if (TextUtils.isEmpty(pwd)) {
                        Log.d("ttx", "ShowBaseView: empty name")
                        Utils.get().toast("empty pwd")
                        return@Button
                    }
                    if (TextUtils.isEmpty(email)) {
                        Log.d("ttx", "ShowBaseView: empty email")
                        Utils.get().toast("empty eamil")
                        return@Button
                    }
                    val user = DbManager.get().queryUser(text, email)
                    if (user != null) {
                        Utils.get().toast("register fail user has register")
                        return@Button
                    }
                    val userBean = UserBean()
                    userBean.name = text
                    userBean.email = email
                    userBean.pwd = Utils.get().getMD5Hash(pwd)
                    try {
                        DbManager.get().insertData(userBean)
                        Utils.get().toast("register success")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                },

                Modifier
                    .padding(start = 20.dp)
            ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue1 // 使用导入的颜色
            ))
            {
                Text(text = "Register", fontSize = TextUnit(20f, TextUnitType.Sp))
            }
        }
    }
}
