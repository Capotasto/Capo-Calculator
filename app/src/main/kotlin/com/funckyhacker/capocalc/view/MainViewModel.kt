package com.funckyhacker.capocalc.view

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import timber.log.Timber

class MainViewModel : ViewModel(), LifecycleObserver {

    var detail = ObservableField<String>("")

    var sum = ObservableField<String>("0")

    override fun onCleared() {
        Timber.i("onCleared")
        super.onCleared()
    }

    fun onClick00() {
        Timber.i("onClick 00")
        detail.set(detail.get() + "00")
    }


    fun onClick0() {
        Timber.i("onClick 0")
        detail.set(detail.get() + "0")
    }


    fun onClickDot() {
        Timber.i("onClick .")
        detail.set(detail.get() + ".")
    }


    fun onClickEqual() {
        Timber.i("onClick =")
        //detail.set(detail.get() + "=")
        // doCalculate();
    }


    fun onClick1() {
        Timber.i("onClick 1")
        detail.set(detail.get() + "1")
    }


    fun onClick2() {
        Timber.i("onClick 2")
        detail.set(detail.get() + "2")
    }


    fun onClick3() {
        Timber.i("onClick 3")
        detail.set(detail.get() + "3")
    }


    fun onClickPlus() {
        Timber.i("onClick +")
        detail.set(detail.get() + "+")
    }

    fun onClick4() {
        Timber.i("onClick 4")
        detail.set(detail.get() + "4")
    }


    fun onClick5() {
        Timber.i("onClick 5")
        detail.set(detail.get() + "5")
    }

    fun onClick6() {
        Timber.i("onClick 6")
        detail.set(detail.get() + "6")
    }


    fun onClickMinus() {
        Timber.i("onClick -")
        detail.set(detail.get() + "-")
    }


    fun onClick7() {
        Timber.i("onClick 7")
        detail.set(detail.get() + "7")
    }


    fun onClick8() {
        Timber.i("onClick 8")
        detail.set(detail.get() + "8")
    }


    fun onClick9() {
        Timber.i("onClick 9")
        detail.set(detail.get() + "9")
    }


    fun onClickMultiply() {
        Timber.i("onClick *")
        detail.set(detail.get() + "*")
    }

    fun onClickC() {
        Timber.i("onClick C")
        val current = detail.get()
        detail.set(current?.substring(0, current.length -1) ?: "")
    }


    fun onClickBracketOpen() {
        Timber.i("onClick (")
        detail.set(detail.get() + "(")
    }


    fun onClickBracketClose() {
        Timber.i("onClick )")
        detail.set(detail.get() + ")")
    }


    fun onClickDivide() {
        Timber.i("onClick /")
        detail.set(detail.get() + "/")
    }
}
