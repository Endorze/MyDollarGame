package com.example.myonedollargame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myonedollargame.databinding.FragmentGamePlayBinding


class GamePlay : Fragment() {

    private lateinit var binding: FragmentGamePlayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamePlayBinding.inflate(layoutInflater)

        binding.initializeGameButton.setOnClickListener{
            var action = GamePlayDirections.actionGamePlayToLevel1fragment()
            Navigation.findNavController(binding.root).navigate(action)
        }

        return binding.root
    }
}