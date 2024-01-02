package com.example.myonedollargame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.myonedollargame.databinding.FragmentLevel3fragmentBinding
import com.example.myonedollargame.databinding.FragmentLevel4fragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [level4fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class level4fragment : Fragment() {
    private lateinit var binding: FragmentLevel4fragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel4fragmentBinding.inflate(layoutInflater)
        var level = LogicLevel()
        updateText()
        binding.victoryLayout.isVisible = false



        binding.node1Button.setOnClickListener {
            node1.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        binding.node2Button.setOnClickListener {
            node2.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        binding.node3Button.setOnClickListener {
            node3.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        binding.node4Button.setOnClickListener {
            node4.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        binding.node5Button.setOnClickListener {
            node5.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        binding.node6Button.setOnClickListener {
            node6.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }

        binding.node7Button.setOnClickListener {
            node7.click()
            updateText()
            if (checkWin()) {
                victory()
            }
        }
        return binding.root
    }

    val level = LogicLevel()
    val node1 = level.makeNode(-2)
    val node2 = level.makeNode(0)
    val node3 = level.makeNode(3)
    val node4 = level.makeNode(3)
    val node5 = level.makeNode(-3)
    val node6 = level.makeNode(4)
    val node7 = level.makeNode(-1)

    init {
        level.connectNodes(node1, node3)
        level.connectNodes(node1, node4)
        level.connectNodes(node2, node4)
        level.connectNodes(node2, node3)
        level.connectNodes(node2, node5)
        level.connectNodes(node6, node3)
        level.connectNodes(node7, node1)
    }

    fun updateText() {
        binding.node1Button.text = node1.value.toString()
        binding.node2Button.text = node2.value.toString()
        binding.node3Button.text = node3.value.toString()
        binding.node4Button.text = node4.value.toString()
        binding.node5Button.text = node5.value.toString()
        binding.node6Button.text = node6.value.toString()
        binding.node7Button.text = node7.value.toString()
    }

    fun checkWin(): Boolean {
        for (connections in level.nodeList) {
            if (connections.value < 0) {
                return false
            }
        }
        return true
    }
    fun victory() {
        binding.victoryButton.text = "Finish Chapter"
        binding.victoryLayout.isVisible = true
        binding.victoryButton.setOnClickListener {
            val action = level4fragmentDirections.actionLevel4fragmentToVictorychapter1fragment()
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}