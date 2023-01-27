package com.example.my

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my.databinding.ActivityUserlistBinding
import com.google.firebase.database.*


class UserlistActivity : BaseActivity() {

    //   lateinit var mTopicData: UserData
    lateinit var mReplyAdapter: MyAdapter
    val mReplyList = ArrayList<User>()
    private lateinit var dbref : DatabaseReference
    lateinit var mChatData: User
    lateinit var binding: ActivityUserlistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_userlist)


        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        FirebaseDatabase.getInstance().reference.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    mReplyList.clear()
                    for (child in snapshot.children) {
                        mReplyList.add(
                            User(
                                child.key.toString(),
                                child.value.toString(),
                            child.value.toString()
                                )
                        )
                    }
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

