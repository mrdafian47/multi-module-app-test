package com.dafian.android.feature_user.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.feature_user.R
import com.dafian.android.feature_user.entity.User
import kotlinx.android.synthetic.main.row_user.view.*

class UserAdapter(
    private val userList: List<User>
) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    override fun getItemCount(): Int = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userList[position])
    }

    class UserHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            with(itemView) {
                tvUserName.text = user.name
                tvUserEmail.text = user.email
            }
        }
    }
}