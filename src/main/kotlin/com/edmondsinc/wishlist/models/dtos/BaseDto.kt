package com.edmondsinc.wishlist.models.dtos

import java.util.*

open class BaseDto(
    var id: Long = 1L,
    var guid: UUID = UUID.randomUUID()
)