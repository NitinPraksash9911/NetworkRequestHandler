package com.example.catcraft.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import com.example.catcraft.arch.BaseActivity
import com.example.catcraft.databinding.ActivityMainBinding
import com.example.catcraft.ui.listframent.ui.CatBreedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: CatBreedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}