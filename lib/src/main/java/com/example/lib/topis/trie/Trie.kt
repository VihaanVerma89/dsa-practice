package com.example.lib.topis.trie

class Trie() {

    private val root: TrieNode = TrieNode('0')

    fun insert(word: String) {

        var children = root.children

        for ((i, c) in word.withIndex()) {

            val containsKey = children.containsKey(c)
            var trieNode: TrieNode

            if (containsKey) {
                trieNode = children[c]!!
            } else {
                trieNode = TrieNode(c)
                children[c] = trieNode
            }

            children = trieNode.children
            if (i == word.length - 1) {
                trieNode.isLeaf = true
            }
        }
    }

    fun contains(word: String): Boolean {
        var children = root.children
        var found = false
        for ((i, c) in word.withIndex()) {
            val contains = children.contains(c)
            if (contains) {
                val trieNode = children[c]
                trieNode?.let {
                    children = trieNode.children
                    if (i == word.length - 1 && trieNode.isLeaf) {
                        found = true
                    }
                }
            } else {
                found = false
                break
            }
        }
        return found
    }

    fun startsWith() {

    }

    fun searchNode() {

    }
}

fun printIfTrieContains(trie: Trie, searchTerm: String) {
    val contains = trie.contains(searchTerm)
    println("contains $searchTerm: $contains")
}

fun main() {
    val trieNode = TrieNode('v')
    val trie = Trie()
    trie.insert("make")
    trie.insert("man")
    trie.insert("male")
    trie.insert("mask")
    trie.insert("mast")

    printIfTrieContains(trie,"man")
    printIfTrieContains(trie,"make")
    printIfTrieContains(trie,"maks")
    printIfTrieContains(trie,"mask")
}