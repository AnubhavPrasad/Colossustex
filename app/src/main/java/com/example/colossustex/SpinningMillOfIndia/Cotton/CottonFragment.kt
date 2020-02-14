package com.example.colossustex.SpinningMillOfIndia.Cotton

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentCottonBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CottonFragment : Fragment() {
    lateinit var datalist: MutableList<Data>
    lateinit var binding: FragmentCottonBinding
    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cotton, container, false)
        binding.recyclerId.layoutManager = LinearLayoutManager(context)
        firebaseDatabase = FirebaseDatabase.getInstance()
        datalist = mutableListOf()
        binding.toolbar.inflateMenu(R.menu.cotton_menu)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_id -> findNavController().navigate(R.id.action_cottonFragment_to_homePage)

            }
            true
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val mref = firebaseDatabase.getReference("Cotton")
        mref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    datalist.clear()
                    for (datasnap in p0.children) {
                        val data = datasnap.getValue(Data::class.java)
                        datalist.add(data!!)
                    }
                }

                binding.recyclerId.adapter = CottonAdapter(datalist)
            }

        })
        return binding.root

    }


}
