package com.example.lib.topics.trie


class TrieNode(val node: Char) {
    val children = hashMapOf<Char, TrieNode>()
    var isLeaf = false
}

