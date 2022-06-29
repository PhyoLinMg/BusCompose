package dev.linmg.buscompose.uis

data class CartModel(
    val id:Int,
    val title: String,
    var count: Int = 0,
    val price: Double,
)
