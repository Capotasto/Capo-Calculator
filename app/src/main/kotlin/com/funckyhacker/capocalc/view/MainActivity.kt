package com.funckyhacker.capocalc.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.FOCUS_RIGHT
import com.funckyhacker.capocalc.R
import com.funckyhacker.capocalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fullscreen
        findViewById<View>(android.R.id.content).systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        lifecycle.addObserver(viewModel)
        binding.apply {
            setLifecycleOwner(this@MainActivity)
            viewModel = this@MainActivity.viewModel
        }

        binding.detail.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.horizontalView.fullScroll(FOCUS_RIGHT)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

    }
}
