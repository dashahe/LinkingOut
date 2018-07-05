package com.sao

import java.text.SimpleDateFormat
import java.util.*

class TextUtil{

    companion object {
        fun formatDate():String{
            var date = Date()
            var simpledataformat = SimpleDateFormat("yy/MM/dd_HH:mm")
            return "${simpledataformat.format(date)}"
        }
    }
}