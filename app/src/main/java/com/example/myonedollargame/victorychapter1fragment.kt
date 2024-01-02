package com.example.myonedollargame

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.myonedollargame.databinding.FragmentVictorychapter1fragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [victorychapter1fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class victorychapter1fragment : Fragment() {
    private lateinit var binding: FragmentVictorychapter1fragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVictorychapter1fragmentBinding.inflate(layoutInflater)

        var fadeIn = AlphaAnimation(0.0f, 1.0f)
        var fadeOut = AlphaAnimation(1.0f, 0.0f)

        fadeIn.setDuration(1200);
        fadeIn.setFillAfter(true);
        fadeOut.setDuration(1200);
        fadeOut.setFillAfter(true);

        binding.text.startAnimation(fadeIn)

        runLater(fadeIn.duration + 2000) {
            binding.text.startAnimation(fadeOut)

            runLater(fadeOut.duration) {
                binding.text.text = "Hej";
                binding.text.startAnimation(fadeIn)

            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }
    fun runLater(value: Long, lambda: Runnable) {
        Handler(Looper.getMainLooper()).postDelayed(lambda, value)
    }
}