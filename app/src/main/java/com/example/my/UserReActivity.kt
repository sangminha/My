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
        FirebaseDatabase.getInstance().reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                binding.firstShort.text=dataSnapshot.value.toString()
                binding.firstShort.text
                mReplyAdapter.notifyDataSetChanged()



            }


            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


    override fun setValues() {
        mReplyAdapter = MyAdapter(mContext, mReplyList)
        binding.profile.adapter = mReplyAdapter
        binding.profile.layoutManager = LinearLayoutManager(mContext)
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