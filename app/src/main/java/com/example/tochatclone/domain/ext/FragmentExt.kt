package com.example.tochatclone.domain.ext

import androidx.fragment.app.Fragment

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

fun Fragment.hideKeyboard() {
   view?.let { activity?.hideKeyboard(it) }
}