package com.fiqih.ta_funherbal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.fiqih.ta_funherbal.Adapter.TanamanAdapter
import com.fiqih.ta_funherbal.model.TanamanData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_tanaman.*

class TanamanActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var tanamanList:ArrayList<TanamanData>
    private lateinit var mAdapter:TanamanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanaman)

        tanamanList = ArrayList()
        mAdapter = TanamanAdapter(this,tanamanList)
        recyclerTanaman.layoutManager = LinearLayoutManager(this)
        recyclerTanaman.setHasFixedSize(true)
        // recyclerAnimals.adapter = mAdapter
        /**getData firebase*/
        getTanamanData()
    }

    private fun getTanamanData(){
       mDataBase = FirebaseDatabase.getInstance().getReference("Tanaman")
        mDataBase.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (tanamanSnapshot in snapshot.children) {
                        val tanaman = tanamanSnapshot.getValue(TanamanData::class.java)
                        tanamanList.add(tanaman!!)
                    }
                    recyclerTanaman.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@TanamanActivity,
                    error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}