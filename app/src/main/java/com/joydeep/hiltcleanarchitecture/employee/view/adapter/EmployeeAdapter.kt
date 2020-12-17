package com.joydeep.hiltcleanarchitecture.employee.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joydeep.domain.login.entity.UsersResponse
import com.joydeep.hiltcleanarchitecture.R
import com.joydeep.hiltcleanarchitecture.databinding.ViewUserBinding

class EmployeeAdapter(
    private val usersList: MutableList<UsersResponse.User>
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.setData(usersList[position])
    }

    override fun getItemCount(): Int = usersList.size

    fun updateData(usersList: List<UsersResponse.User>) {
        this.usersList.clear()
        this.usersList.addAll(usersList)
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(private val parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_user, parent, false)
    ) {
        fun setData(user: UsersResponse.User) {
            val binding = ViewUserBinding.bind(itemView)

            // ID
            val userId = user.id
            binding.userId.text = "UserId: $userId"

            // Name
            val name = user.first_name + " " + user.last_name
            binding.userName.text = "Name: $name"

            // Email
            val email = user.email
            binding.userEmail.text = "Email: $email"

            // avatar
            val url = user.avatar
            Glide
                .with(parent)
                .load(url)
                .centerCrop()
                .into(binding.userIcon)
        }
    }
}