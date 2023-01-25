package com.example.my


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.my.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class MyAdapter(
    val mContext : Context, val mList : List<User>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: User) {

            val short = itemView.findViewById<TextView>(R.id.tvfirstName)
            val long_1 = itemView.findViewById<TextView>(R.id.tvlastName)
            val short_1 = itemView.findViewById<TextView>(R.id.tvage)

            short.text=item.short
            long_1.text=item.long_1
            short_1.text=item.short_1


//            수정 버튼 클릭 이벤트

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.activity_user, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}