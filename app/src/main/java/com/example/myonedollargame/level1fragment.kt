package com.example.myonedollargame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myonedollargame.databinding.FragmentLevel1fragmentBinding


class level1fragment : Fragment() {

    private lateinit var binding: FragmentLevel1fragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLevel1fragmentBinding.inflate(layoutInflater)
        var level = LogicLevel()

        updateText()
        binding.node1Button.setOnClickListener{
            node1.click()
            updateText()
            checkWin()
        }
        binding.node2Button.setOnClickListener{
            node2.click()
            updateText()
            if (checkWin()) {

            }
        }
        binding.node3Button.setOnClickListener{
            node3.click()
            updateText()
            checkWin()
        }
        binding.node4Button.setOnClickListener{
            node4.click()
            updateText()
            checkWin()
        }
        binding.node5Button.setOnClickListener{
            node5.click()
            updateText()
            checkWin()
        }



        // Inflate the layout for this fragment
        return binding.root
    }
       val level = LogicLevel()
       val node1 = level.makeNode(5)
       val node2 = level.makeNode(2)
       val node3 = level.makeNode(-2)
       val node4 = level.makeNode(-2)
       val node5 = level.makeNode(-1)

    init {
        level.connectNodes(node1, node3)
        level.connectNodes(node1, node4)
        level.connectNodes(node2, node3)
        level.connectNodes(node2, node4)
        level.connectNodes(node2, node5)
    }
    fun updateText() {
        binding.node1Button.text = node1.value.toString()
        binding.node2Button.text = node2.value.toString()
        binding.node3Button.text = node3.value.toString()
        binding.node4Button.text = node4.value.toString()
        binding.node5Button.text = node5.value.toString()
    }
    fun checkWin() : Boolean {
        for (connections in level.nodeList) {
            if (connections.value < 0) {
                return false
            }
        }

        return true
    }
}