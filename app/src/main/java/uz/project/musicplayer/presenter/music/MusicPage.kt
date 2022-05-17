package uz.project.musicplayer.presenter.music

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.project.carwash24.utils.isMyServiceRunning
import uz.project.carwash24.utils.scope
import uz.project.musicplayer.R
import uz.project.musicplayer.databinding.PageMusicBinding
import uz.project.musicplayer.model.remote.Model
import uz.project.musicplayer.service.BackgroundSoundService


class MusicPage : Fragment(R.layout.page_music) {
    private val binding by viewBinding(PageMusicBinding::bind)
    private val viewModel by viewModel<MusicPageViewModel>()
    private lateinit var currentMusic: Model

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        currentMusic = bundle?.getParcelable<Model>("objecttt")!!
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        musicImg.setImageResource(currentMusic.img!!)
        musicName.text = currentMusic.musicName
        musicSinger.text = currentMusic.singer

        pauseMusicButton.setOnClickListener {
            if (requireActivity().isMyServiceRunning(BackgroundSoundService::class.java)) {
                requireContext().stopService(
                    Intent(
                        requireContext(),
                        BackgroundSoundService::class.java
                    )
                )
                pauseMusicButton.setImageResource(R.drawable.ic_baseline_play)
            } else {
                val intent = Intent(requireContext(), BackgroundSoundService::class.java)
                requireContext().startService(intent)
                pauseMusicButton.setImageResource(R.drawable.ic_baseline_pause)
            }
        }


    }


}