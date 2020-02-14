package com.example.colossustex.SpinningMillOfIndia.Viscose

import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.R
import com.example.colossustex.databinding.FragmentViscoseBinding
import com.example.dialogcustom.MyAdapter

class ViscoseFragment : Fragment() {
    lateinit var list: MutableList<Int>
    lateinit var binding: FragmentViscoseBinding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = mutableListOf()
        for (i in 1..200) {
            list.add(i)
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_viscose, container, false)
        binding.toolbar.inflateMenu(R.menu.cotton_menu)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_id -> findNavController().navigate(R.id.action_viscoseFragment_to_homePage)
            }
            true
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.spinnerViscose.setOnClickListener {

            showdialog()
        } //Call for dialog function

        binding.vortexId.setOnClickListener {
            binding.ringspunId.isSelected = false
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)
            binding.openendId.isSelected = false
            Toast.makeText(context, binding.vortexId.text, Toast.LENGTH_SHORT).show()
            binding.vortexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.vortexId.setTextColor(Color.WHITE)
            it.isSelected = true

        }
        binding.ringspunId.setOnClickListener {
            binding.openendId.isSelected = false
            binding.vortexId.isSelected = false
            binding.openendId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.openendId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.ringspunId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.ringspunId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true

        }
        binding.openendId.setOnClickListener {
            binding.ringspunId.isSelected = false
            binding.ringspunId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.ringspunId.setTextColor(Color.BLACK)
            binding.vortexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.vortexId.setTextColor(Color.BLACK)
            binding.vortexId.isSelected = false
            binding.openendId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.openendId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.openendId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true
        }
        binding.warpId.setOnClickListener {
            binding.weftId.isSelected = false
            binding.weftId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.weftId.setTextColor(Color.BLACK)
            binding.warpId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.warpId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.warpId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true
        }
        binding.weftId.setOnClickListener {
            binding.warpId.isSelected = false
            binding.warpId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.warpId.setTextColor(Color.BLACK)
            binding.weftId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.weftId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.weftId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true

        }
        binding.regularId.setOnClickListener {
            binding.dyedId.isSelected = false
            binding.spandexId.isSelected = false
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_right)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_clicked_left)
            binding.regularId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.regularId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true
        }
        binding.dyedId.setOnClickListener {
            binding.regularId.isSelected = false
            binding.spandexId.isSelected = false
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.spandexId.setTextColor(Color.BLACK)
            binding.dyedId.setBackgroundResource(R.drawable.viscose_clicked_middle)
            binding.dyedId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.dyedId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true
        }
        binding.spandexId.setOnClickListener {
            binding.dyedId.isSelected = false
            binding.regularId.isSelected = false
            binding.dyedId.setBackgroundResource(R.drawable.viscose_text_middle)
            binding.dyedId.setTextColor(Color.BLACK)
            binding.regularId.setBackgroundResource(R.drawable.viscose_text_left)
            binding.regularId.setTextColor(Color.BLACK)
            binding.spandexId.setBackgroundResource(R.drawable.viscose_clicked_right)
            binding.spandexId.setTextColor(Color.WHITE)
            Toast.makeText(context, binding.spandexId.text, Toast.LENGTH_SHORT).show()
            it.isSelected = true
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun showdialog() {
        val dialog = Dialog(context!!)
        dialog.setContentView(R.layout.viscose_dialog)
        dialog.create()
        val recycler = dialog.findViewById<RecyclerView>(R.id.viscose_recycler)
        recycler.layoutManager = GridLayoutManager(context, 4)
        recycler.adapter = MyAdapter(list)
        dialog.show()

    }   //Function to show dialog 1


}