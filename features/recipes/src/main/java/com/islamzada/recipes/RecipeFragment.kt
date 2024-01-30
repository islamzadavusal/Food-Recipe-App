package com.islamzada.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamzada.common.base.BaseFragment
import com.islamzada.recipes.databinding.FragmentRecipeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeFragment : BaseFragment <FragmentRecipeBinding, RecipeViewModel> (FragmentRecipeBinding::inflate) {

    val viewModel : RecipeViewModel by viewModels()

    private lateinit var adapter : RecipeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvAdapter()

        lifecycleScope.launch {
            viewModel.getFlights()

        }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.setData(it?.recipes ?: listOf())
        }

    }


    override fun mViewModel(): RecipeViewModel {
        return viewModel
    }

    private fun initRvAdapter(){
        adapter = RecipeListAdapter()
        binding.rvRcp.layoutManager = LinearLayoutManager(context)
        binding.rvRcp.adapter = adapter
    }

}