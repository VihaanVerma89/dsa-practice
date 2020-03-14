package com.example.lib.topis.trie


class TrieNode(val node: Char) {
    val children = hashMapOf<Char, TrieNode>()
    var isLeaf = false
}

