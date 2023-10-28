package com.example.p12_mad

class Contact (var _id:String, var name:String, var num:String,var addr:String) {

    companion object{

        var contactArray: List<Contact> = ArrayList()
    }

}