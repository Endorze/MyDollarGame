package com.example.myonedollargame

import java.util.LinkedList

open class LogicNode {
    var value = 0;
    var nodeConnections = LinkedList<LogicNode>()

    fun click() : Boolean {
        if (value > 0) {
            for (connection in nodeConnections) {
                connection.value++;
                value--;
            }
        }
        return false
    }
}