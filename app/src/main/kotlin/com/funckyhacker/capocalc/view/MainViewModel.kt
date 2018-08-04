package com.funckyhacker.capocalc.view

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import timber.log.Timber

class MainViewModel : ViewModel(), LifecycleObserver {

    var detail = ObservableField<String>("0")

    var sum = ObservableField<String>("")

    override fun onCleared() {
        Timber.i("onCleared")
        super.onCleared()
    }

    fun onClick00() {
        Timber.i("onClick00")
    }


    fun onClick0() {
        Timber.i("onClick00")
    }


    fun onClickDot() {
        Timber.i("onClick00")
    }


    fun onClickEqual() {
        Timber.i("onClick00")
    }


    fun onClick1() {
        Timber.i("onClick00")
    }


    fun onClick2() {
        Timber.i("onClick00")
    }


    fun onClick3() {
        Timber.i("onClick00")
    }


    fun onClickPlus() {
        Timber.i("onClick00")
    }

    fun onClick4() {
        Timber.i("onClick00")
    }


    fun onClick5() {
        Timber.i("onClick00")
    }

    fun onClick6() {
        Timber.i("onClick00")
    }


    fun onClickMinus() {
        Timber.i("onClick00")
    }


    fun onClick7() {
        Timber.i("onClick00")
    }


    fun onClick8() {
        Timber.i("onClick00")
    }


    fun onClick9() {
        Timber.i("onClick00")
    }


    fun onClickMultiply() {
        Timber.i("onClick00")
    }

    fun onClickC() {
        Timber.i("onClick00")
    }


    fun onClickBracketOpen() {
        Timber.i("onClick00")
    }


    fun onClickBracketClose() {
        Timber.i("onClick00")
    }


    fun onClickDivide() {
        Timber.i("onClick00")
    }
}
