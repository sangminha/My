package com.example.my


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(
    private val mContext : Context, private val mList : List<User>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item: User) {

            val short =  itemView.findViewById<TextView>(R.id.tvfirstName_1)
            val long1 = itemView.findViewById<TextView>(R.id.tvlastName_1)
            short.text=item.short.toString()
            long1.text=item.long_1.toString()

//            수정 버튼 클릭 이벤트

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.userlist, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}