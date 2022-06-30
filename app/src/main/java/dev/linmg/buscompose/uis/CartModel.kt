package dev.linmg.buscompose.uis

data class CartModel(
    val id: Int,
    val title: String,
    var count: Int = 0,
    val price: Double,
)

val list: MutableList<CartModel> = mutableListOf(
    CartModel(1, "name1", price = 1.0),
    CartModel(2, "name2", price = 1.0),
    CartModel(3, "name3", price = 1.0),
    CartModel(4, "name4", price = 1.0),
    CartModel(5, "name5", price = 1.0),
    CartModel(6, "name6", price = 1.0),
    CartModel(7, "name7", price = 1.0),
    CartModel(8, "name8", price = 1.0)
)