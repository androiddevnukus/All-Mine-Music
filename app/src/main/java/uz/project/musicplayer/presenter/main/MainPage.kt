package uz.project.musicplayer.presenter.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.carwash24.utils.scope
import uz.project.musicplayer.R
import uz.project.musicplayer.databinding.PageMainBinding
import uz.project.musicplayer.model.remote.Model
import uz.project.musicplayer.presenter.adapters.MainMusicsAdapter
import uz.project.musicplayer.service.BackgroundSoundService

class MainPage : Fragment(R.layout.page_main) {
    private val binding by viewBinding(PageMainBinding::bind)
    private lateinit var myAdapter: MainMusicsAdapter
    private val viewModel by viewModel<MainPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)
        rcMusic.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        myAdapter = MainMusicsAdapter { onItemClick(it) }
        myAdapter.submitList(viewModel.getMusicsList())
        rcMusic.adapter = myAdapter

    }

    private fun onItemClick(item: Model) {
        val bundle = Bundle()
        bundle.putParcelable("objecttt", item)
        val intent = Intent(
            requireContext(),
            BackgroundSoundService(item.id - 1, viewModel.getMusicsList())::class.java
        )
        requireContext().startService(intent)
        findNavController().navigate(R.id.action_global_musicPage, bundle)

    }

}