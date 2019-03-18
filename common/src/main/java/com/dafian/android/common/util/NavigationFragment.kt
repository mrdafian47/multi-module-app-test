package com.dafian.android.common.util

interface NavigationFragment {

    fun onBackPressed(): Boolean {
        return false
    }

    fun onUserInteraction() {}
}