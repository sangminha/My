package com.example.my

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my.databinding.ActivityUserBinding
import com.google.firebase.database.*


class UserReActivity : BaseActivity() {

    //   lateinit var mTopicData: UserData
    lateinit var mReplyAdapter: MyAdapter
    val mReplyList = ArrayList<User>()
    private lateinit var dbref : DatabaseReference

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


    }


    override fun setValues() {
        FirebaseDatabase.getInstance().reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    User(
                        short = snapshot.value.toString(),
                        long_1 = snapshot.value.toString(),
                        short_1 = snapshot.value.toString()
                    )

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

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}