package com.edu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.edu.demo.db.DbManager
import com.edu.demo.pages.LoginPage
import com.edu.demo.pages.MainPage
import com.edu.demo.pages.NavParam
import com.edu.demo.pages.NavUtil
import com.edu.demo.pages.RegisterPage
import com.edu.demo.pages.composableX
import com.edu.demo.ui.theme.DemoTheme
import com.edu.demo.util.Utils

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {
                    NavContent()
                }
            }
        }
    }
}

/**
 * 初始化nav host
 */
@Composable
fun NavContent() {
    Utils.get().init(context = LocalContext.current)
    DbManager.get().init(context = LocalContext.current)
    val navHostController = rememberNavController()
    NavUtil.get().init(navHostController = navHostController)

    NavHost(navController = navHostController, startDestination = RouteConfig.LOGIN_PAGE) {
        //配置登陆页面路由
        composableX(RouteConfig.LOGIN_PAGE) { LoginPage() }
        //配置注册页面路由
        composableX(RouteConfig.REGISTER_PAGE) { RegisterPage() }
        ////配置主页面路由
        composableX(
            RouteConfig.MAIN_PAGE, params = listOf(NavParam("name"), NavParam("id"))
        ) { MainPage(it.arguments?.getString("name"), it.arguments?.getString("id")) }
    }
}

object RouteConfig {
    const val LOGIN_PAGE = "LOGIN_PAGE"
    const val REGISTER_PAGE = "REGISTER_PAGE"
    const val MAIN_PAGE = "MAIN_PAGE"
}