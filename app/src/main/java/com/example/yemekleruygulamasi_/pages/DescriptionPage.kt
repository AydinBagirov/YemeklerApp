package com.example.yemekleruygulamasi_.pages

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yemekleruygulamasi_.R
import com.example.yemekleruygulamasi_.entity.Yemekler


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionPage(yemek: Yemekler){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("${yemek.yemek_ad}") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topBarColor),
                    titleContentColor = colorResource(id = R.color.white),
                )
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "${yemek.yemek_ad}",color = Color.Blue,fontSize = 50.sp)
                Text(text = "${yemek.yemek_fiyat}",color = Color.Blue,fontSize = 25.sp)
                Button(onClick = {
                    Log.e("Yemek","sipariş verildi")
                },
                    modifier = Modifier.size(250.dp,50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.teal_700),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Sipariş Ver")
                }
            }
        }
    )
}