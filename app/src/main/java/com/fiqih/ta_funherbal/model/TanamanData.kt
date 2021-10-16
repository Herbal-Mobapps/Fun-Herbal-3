package com.fiqih.ta_funherbal.model

class TanamanData {

    var name :String? = null
    var info:String? = null
    var img:String? = null
    constructor(){}

    constructor(
        name:String? = null,
        info:String? = null,
        img:String? = null
    ){
        this.name = name
        this.info = info
        this.img = img
    }
}