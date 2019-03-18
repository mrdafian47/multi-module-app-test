package com.dafian.android.common.util.extension

import android.app.Activity
import android.content.SharedPreferences
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Allows calls like
 *
 * `supportFragmentManager.inTransaction { add(...) }`
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun Activity.getStatusBarDimension(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun Activity.getActionBarSizeDimension(): Int {
    val ta = theme.obtainStyledAttributes(
        intArrayOf(android.R.attr.actionBarSize))
    return ta.getDimension(0, 0f).toInt()
}

fun SharedPreferences.setString(key: String, value: String?) {
    this.edit().putString(key, value).apply()
}

fun SharedPreferences.setInt(key: String, value: Int) {
    this.edit().putInt(key, value).apply()
}

fun SharedPreferences.setBoolean(key: String, value: Boolean) {
    this.edit().putBoolean(key, value).apply()
}