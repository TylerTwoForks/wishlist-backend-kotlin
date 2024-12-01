package com.edmondsinc.wishlist.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Table(
    name = "users"
)
@Entity
class User(val firstName: String,

           val lastName: String,

           @Column(unique = true)
           val email: String) :

    AbstractEntity() { //extends AbstractEntity to obtain base items such as Id and CreatedDate


//Three ways to initialize a class.

        //#1 in the constructor above.  by using "val" in the constructor name, it's like doing #2 below.

    //#2 assign directly to variable
//    val lastName: String = lastName
//    val email: String = email

    // #3 use an init block if you need to do some logic to assign the value.
//        init{
//            firstName = _firstName
//            lastName = _lastName
//        }

}