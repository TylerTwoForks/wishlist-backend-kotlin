package com.edmondsinc.wishlist.models.dtos.response

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

class ErrorResDto(
    val errorMessage: String?,
    val stackTrace: String?
) {

    companion object {
        fun toResponseEntity(message:String?, stack:String?, httpStatusCode: HttpStatusCode):ResponseEntity<ErrorResDto>{
            return ResponseEntity<ErrorResDto>(ErrorResDto(message, stack), httpStatusCode)
        }
    }

}