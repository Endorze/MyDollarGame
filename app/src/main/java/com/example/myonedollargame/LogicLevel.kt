package com.example.myonedollargame

import java.util.LinkedList

open class LogicLevel {

    var nodeList = LinkedList<LogicNode>()


    fun makeNode(value: Int): LogicNode {
        var node = LogicNode()
        node.value = value
        nodeList.add(node)
        return node
    }
    fun connectNodes(n1 : LogicNode, n2 : LogicNode) {
        n1.nodeConnections.add(n2)
        n2.nodeConnections.add(n1)
    }
}