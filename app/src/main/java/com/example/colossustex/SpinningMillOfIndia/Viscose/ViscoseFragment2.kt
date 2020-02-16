package com.example.colossustex.SpinningMillOfIndia.Viscose


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.databinding.ViscoseFragment2Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViscoseFragment2 : Fragment() {
    lateinit var database: FirebaseDatabase
    lateinit var binding: ViscoseFragment2Binding
    lateinit var list: MutableList<AllMillsData>
    lateinit var data: AllMillsData
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.viscose_fragment2, container, false)
        binding.viscoseRecycler2.layoutManager = LinearLayoutManager(context)
        database = FirebaseDatabase.getInstance()
        val mdata = database.getReference("Viscose")
        mdata.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                list = mutableListOf()
                for (snapshot in p0.children) {
                    val store = snapshot.getValue(AllMillsData::class.java)
                    list.add(store!!)
                }
                binding.viscoseRecycler2.adapter = RecyclerAdapter2(list)
            }

        })
        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            @SuppressLint("DefaultLocale")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newlist = mutableListOf<AllMillsData>()
                for (i in list) {
                    if (i.text1.toLowerCase().trim().contains(s.toString().toLowerCase().trim())) {
                        newlist.add(i)
                    }
                }
                binding.viscoseRecycler2.adapter = RecyclerAdapter2(newlist)
            }

        })  //Searching feature is implemented
        return binding.root
    }


}
