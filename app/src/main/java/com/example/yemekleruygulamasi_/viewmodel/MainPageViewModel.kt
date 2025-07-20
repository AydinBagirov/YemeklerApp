package com.example.yemekleruygulamasi_.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi_.entity.Yemekler
import com.example.yemekleruygulamasi_.repository.YemeklerDaoRepository

class MainPageViewModel(application: Application): AndroidViewModel(application) {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var _yRepo = YemeklerDaoRepository(application)
    init {
        _yRepo.yemekleriAl()
        yemeklerListesi = _yRepo.yemekleriGetir()                             //LDB
    }
}