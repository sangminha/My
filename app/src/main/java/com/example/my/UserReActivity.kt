package com.example.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my.databinding.ActivityUserBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class UserReActivity : BaseActivity() {

    val realtime =
        FirebaseDatabase.getInstance("https://console.firebase.google.com/u/0/project/newnew-31fbb/database/newnew-31fbb-default-rtdb/data/~2F?hl=ko")

    //   lateinit var mTopicData: UserData
    lateinit var mReplyAdapter: MyAdapter
    val mReplyList = ArrayList<User>()

    lateinit var mChatData: User
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEvents()
        setValues()
    }
    override fun setupEvents() {

        realtime.getReference("users").child("time_1").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("TAG",mReplyList.toString())
                    mReplyList.clear()

                    for (child in snapshot.children) {
                        mReplyList.add(
                            User(
                                child.child("short").value.toString(),
                                child.child("long_1").value.toString(),
                                child.child("short_1").value.toString()
                            )
                        )
                    }
                    mReplyAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            }
        )
    }


    override fun setValues() {
        mReplyAdapter = MyAdapter(mContext, mReplyList)
        binding.userList.adapter = mReplyAdapter
        binding.userList.layoutManager = LinearLayoutManager(mContext)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == REQ_FOR_REPLY) {
//                val chatData = data?.getSerializableExtra("chatData") as ChatData
//                val position = data.getIntExtra("position", 0)
//                 mReplyList[position] = chatData
//                mReplyAdapter.notifyItemChanged(position)
//            }
//        }
//    }
}