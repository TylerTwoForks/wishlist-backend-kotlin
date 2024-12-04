package com.edmondsinc.wishlist.models.dtos.response

import com.edmondsinc.wishlist.models.dtos.UserDto
import com.edmondsinc.wishlist.models.dtos.WishDto

class UserWishCombo(
    val userDto: UserDto,
    val wishListDto: List<WishDto>?
)  {

}