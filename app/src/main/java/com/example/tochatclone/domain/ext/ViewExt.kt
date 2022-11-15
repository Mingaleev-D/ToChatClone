package com.example.tochatclone.domain.ext

import android.view.View

/**
 * @author : Mingaleev D
 * @data : 15/11/2022
 */

fun View.gone(){
   this.visibility = View.GONE
}

fun View.show(){
   this.visibility = View.VISIBLE
}
