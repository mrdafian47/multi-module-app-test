package com.dafian.android.feature_todo.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.feature_todo.R
import com.dafian.android.feature_todo.entity.Todo
import kotlinx.android.synthetic.main.row_todo.view.*

class TodoAdapter(
    private val todoList: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    override fun getItemCount(): Int = todoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bind(todoList[position])
    }

    class TodoHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(todo: Todo) {
            with(itemView) {
                tvTodoTitle.text = todo.title
                tvTodoCompleted.text = todo.completed.toString()
            }
        }
    }
}