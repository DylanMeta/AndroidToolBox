package fr.isen.dylanmetans.androidtoolbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

    class UserAdapter(private val users: ArrayList<UserModel>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            //Add one contact
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_web_cell, parent, false)
            return UserViewHolder(view)
        }

        override fun getItemCount(): Int {
            return users.count()
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            val user = users[position]
            holder.bind(user)
        }

        class UserViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
            //Attach current contact to the display list
            fun bind(user: UserModel) {
                //var personsInfos =
            }
        }
}




