package com.dafian.android.multimoduleapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.dafian.android.common.util.NavigationFragment
import com.dafian.android.common.util.consume
import com.dafian.android.common.util.extension.inTransaction
import com.dafian.android.feature_album.ui.AlbumFragment
import com.dafian.android.feature_todo.ui.TodoFragment
import com.dafian.android.feature_user.ui.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentFragment: NavigationFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEvent()
        checkNavigationInstance(savedInstanceState)
    }

    private fun initEvent() {

        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_album -> consume { replaceFragment(AlbumFragment.newInstance()) }
                R.id.action_todo -> consume { replaceFragment(TodoFragment.newInstance()) }
                R.id.action_user -> consume { replaceFragment(UserFragment.newInstance()) }
                else -> false
            }
        }

        navigationView.setOnNavigationItemReselectedListener {  }
    }

    private fun checkNavigationInstance(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            navigationView.selectedItemId = R.id.action_album
            replaceFragment(AlbumFragment.newInstance())
        } else {
            currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? NavigationFragment
                ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment, F : NavigationFragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(R.id.fragmentContainer, fragment)
        }
    }
}
