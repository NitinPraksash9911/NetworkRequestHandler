package com.example.catcraft.ui.detailfragment.ui

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.catcraft.arch.BaseFragment
import com.example.catcraft.databinding.FragmentBreedDetailBinding
import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.example.catcraft.utils.loadImageWithUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedDetailFragment : BaseFragment<FragmentBreedDetailBinding>
    (FragmentBreedDetailBinding::inflate) {

    private val navArgument: BreedDetailFragmentArgs by navArgs()

    override fun initViews(savedInstanceState: Bundle?) {

        val breadDetail = navArgument.breedDetail
        setUpDetails(breadDetail)
    }

    private fun setUpDetails(breadDetail: CatBreedData) {
        binding.breedIv.loadImageWithUrl(breadDetail.image?.url)
        binding.breedNameTv.text = breadDetail.name
        binding.descTv.text = breadDetail.desc
    }


}