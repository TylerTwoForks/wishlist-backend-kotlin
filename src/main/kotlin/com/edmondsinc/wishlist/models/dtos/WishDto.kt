package com.edmondsinc.wishlist.models.dtos

class WishDto (
    val name: String,
    val description: String?,
    val url: String?,
    val image: String?,
    val price: Double = 0.0,
    val quantity: Int = 1,
    val ranking: Int = 1,
    val userId: Long
)
{

    override fun toString(): String {
        return "WishReqDto(name='$name', description='$description', url='$url', image='$image', price='$price', quatity='$quantity', ranking='$ranking', userId=$userId)"
    }
}
