package com.mbobiosio.common.util

import androidx.navigation.NavDirections

/*
* Created by Mbuodile Obiosio on May 05, 2022.
* Twitter: @cazewonder
* Nigeria
*/
class NavManager {
    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    fun navigate(navDirections: NavDirections) {
        navEventListener?.invoke(navDirections)
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}
