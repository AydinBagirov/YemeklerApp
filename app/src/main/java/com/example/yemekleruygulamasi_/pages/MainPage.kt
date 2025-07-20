package com.example.yemekleruygulamasi_.pages

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.yemekleruygulamasi_.R
import com.example.yemekleruygulamasi_.entity.Yemekler
import com.example.yemekleruygulamasi_.viewmodel.MainPageViewModel
import com.example.yemekleruygulamasi_.viewmodel.MainPageViewModelFactory
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(navController: NavController){
    val context = LocalContext.current
    var viewModel: MainPageViewModel = viewModel(
        factory = MainPageViewModelFactory(context.applicationContext as Application)
    )
    val yemeklerListesi = viewModel.yemeklerListesi.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title ={Text("Yemekler")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.topBarColor),
                    titleContentColor = colorResource(R.color.white)
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate("RecordPage")
                        Log.d("TopAppBar", "Butona tıklandı")
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.add_icon),
                            contentDescription = "",
                            tint = colorResource(R.color.black)
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues).padding(top = 8.dp)) {
                items(
                    count = yemeklerListesi.value!!.count(),
                    itemContent = {
                        val yemek = yemeklerListesi.value[it]!!
                        Card(modifier = Modifier.padding(all = 5.dp).fillMaxWidth()) {
                            Row(modifier = Modifier.clickable{
                                val yemekGson = Gson().toJson(yemek)
                                navController.navigate("DescriptionPage/$yemekGson")
                                Log.d("tiklanma","tiklandi")
                            }) {
                                Row(verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(all = 10.dp).fillMaxWidth()) {
                                    Image(painterResource(R.drawable.baklava),"")
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(verticalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Text("${yemek.yemek_ad}",fontSize = 20.sp)
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text("${yemek.yemek_fiyat}",color = Color.Blue)
                                        }
                                        Icon(painter = painterResource(id = R.drawable.icon1),
                                            contentDescription = "")
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    )
}
