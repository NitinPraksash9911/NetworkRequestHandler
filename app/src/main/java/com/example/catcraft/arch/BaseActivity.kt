package com.example.catcraft.arch

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>( private val bindingInflater: (LayoutInflater) -> VB) : AppCompatActivity(){

    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater).apply {
            setContentView(root)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
