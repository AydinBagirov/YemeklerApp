package com.example.yemekleruygulamasi_.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi_.entity.Yemekler
import com.example.yemekleruygulamasi_.room.VeriTabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class YemeklerDaoRepository(application: Application) {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    val vt: VeriTabani
    init {
        vt = VeriTabani.veritabaniErisim(application)!!
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>>{  //LDB
        return yemeklerListesi
    }

    fun yemekleriAl(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            yemeklerListesi.value = vt.yemeklerDao().getYemekler()
        }
        }
}