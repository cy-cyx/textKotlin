package com.example.textkotlin

/**
 * sealed 密封类
 */
sealed class Expr {
    data class Const(val number: Double) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr() {
        var a: Int = 1
    }
}