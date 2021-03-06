package com.example.colossustex.SpinningMillOfIndia.MainPage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.SpinningMillOfIndia.Viscose.ViscoseActivity
import com.example.colossustex.R
import com.example.colossustex.SpinningMillOfIndia.Fancy.FancyActivity
import com.example.colossustex.SpinningMillOfIndia.Texturised.TexturisedActivity
import com.google.firebase.database.*

class SpinningMillOfIndia : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mDb: DatabaseReference
    private lateinit var posts: ArrayList<post>
    private lateinit var adapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay = inflater.inflate(R.layout.fragment_spinning_mill_of_india, container, false)
        val toolbar =
            lay.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_spinning_mills_in_india)
        val cotton = lay.findViewById<TextView>(R.id.textView_cotton)
        cotton.setOnClickListener {
            it.findNavController().navigate(R.id.action_spinningMillOfIndia_to_cottonFragment)
        }
        val synthetic = lay.findViewById<TextView>(R.id.textView_Synthetic)
        synthetic.setOnClickListener {
            it.findNavController().navigate(R.id.action_spinningMillOfIndia_to_syntheticFragment)
        }
        val viscose = lay.findViewById<TextView>(R.id.textView_viscose)
        viscose.setOnClickListener {
            startActivity(Intent(context,
                ViscoseActivity::class.java))
        }
        val texturised = lay.findViewById<TextView>(R.id.textView_texturised)
        texturised.setOnClickListener {
           startActivity(Intent(context,TexturisedActivity::class.java))
        }
        val fancy = lay.findViewById<TextView>(R.id.textView_fancy)
        fancy.setOnClickListener {
            startActivity(Intent(context,FancyActivity::class.java))
        }
        val postYarnRequirement = lay.findViewById<CardView>(R.id.cardView_post_yarn_requirement)
        val directMillAgentsandTraders =
            lay.findViewById<CardView>(R.id.cardView_direct_mill_agent_and_traders)
        val upButton = lay.findViewById<ImageView>(R.id.upButtonSpinningMillsOfIndia)
        val homeButton = lay.findViewById<ImageView>(R.id.imageView_home_page)


        toolbar.inflateMenu(R.menu.menu_spinning_mills_of_india)

        upButton.setOnClickListener {
            it.findNavController().navigateUp()
        }
        homeButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        recyclerView = lay.findViewById(R.id.recylerView_spinning_mills_of_india)
        recyclerView.layoutManager = LinearLayoutManager(context)

        posts = ArrayList()

        mDb = FirebaseDatabase.getInstance().reference.child("postsSpinningMillsOfIndia")

        mDb.addValueEventListener(
            object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {}

                override fun onDataChange(data: DataSnapshot) {
                    posts.clear()
                    for (dataSnapshot in data.children) {
                        val p = dataSnapshot.getValue(post::class.java)
                        posts.add(p!!)
                    }
                    adapter =
                        PostAdapter(
                            context!!,
                            posts
                        )
                    recyclerView.adapter = adapter
                }
            }
        )


        return lay
    }


}
