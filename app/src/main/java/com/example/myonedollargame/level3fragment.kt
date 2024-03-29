package com.example.myonedollargame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.myonedollargame.databinding.FragmentLevel1fragmentBinding
import com.example.myonedollargame.databinding.FragmentLevel2fragmentBinding
import com.example.myonedollargame.databinding.FragmentLevel3fragmentBinding

class level3fragment : Fragment() {
    private lateinit var binding: FragmentLevel3fragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel3fragmentBinding.inflate(layoutInflater)
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
        return binding.root
    }

    val level = LogicLevel()
    val node1 = level.makeNode(-2)
    val node2 = level.makeNode(0)
    val node3 = level.makeNode(3)
    val node4 = level.makeNode(3)
    val node5 = level.makeNode(-3)
    val node6 = level.makeNode(4)

    init {
        level.connectNodes(node1, node3)
        level.connectNodes(node1, node4)
        level.connectNodes(node2, node4)
        level.connectNodes(node2, node3)
        level.connectNodes(node2, node5)
        level.connectNodes(node6, node3)
    }

    fun updateText() {
        binding.node1Button.text = node1.value.toString()
        binding.node2Button.text = node2.value.toString()
        binding.node3Button.text = node3.value.toString()
        binding.node4Button.text = node4.value.toString()
        binding.node5Button.text = node5.value.toString()
        binding.node6Button.text = node6.value.toString()
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
        binding.victoryLayout.isVisible = true
        binding.victoryButton.setOnClickListener {
            val action = level3fragmentDirections.actionLevel3fragmentToLevel4fragment()
            Navigation.findNavController(binding.root).navigate(action)
        }
    }
}