package com.example.tochatclone.domain.ext

import android.app.Activity
import android.view.View

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

fun Activity.hideKeyboard() {
   hideKeyboard(currentFocus ?: View(this))
}