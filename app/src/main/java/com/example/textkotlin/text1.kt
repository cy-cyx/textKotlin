package com.example.textkotlin

/**
 * JvmDefault
 */
interface interfaceA {
    var A: String?
    var B: Int?

    @JvmDefault
    fun getString() = "A:" + A + "B:" + B
}