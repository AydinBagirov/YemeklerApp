package com.example.yemekleruygulamasi_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.yemekleruygulamasi_.entity.Yemekler
import com.example.yemekleruygulamasi_.pages.DescriptionPage
import com.example.yemekleruygulamasi_.pages.MainPage
import com.example.yemekleruygulamasi_.pages.RecordPage
import com.example.yemekleruygulamasi_.ui.theme.YemeklerUygulamasi_Theme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemeklerUygulamasi_Theme {
                //MainPage()
                pageTransitions()
            }
        }
    }
}


@Composable
fun pageTransitions(){
    val navController = rememberNavController()
    NavHost(navController = navController ,startDestination = "MainPage") {
        composable("MainPage"){
            MainPage(navController)
        }
        composable("DescriptionPage/{yemek}", arguments = listOf(
            navArgument("yemek"){type = NavType.StringType}
        )){
            val yemekJson =it.arguments?.getString("yemek")
            val yemek = Gson().fromJson(yemekJson, Yemekler::class.java)
            DescriptionPage(yemek)
        }
        composable("RecordPage"){
            RecordPage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YemeklerUygulamasi_Theme {
        //MainPage()
        //DescriptionPage()
    }
}

