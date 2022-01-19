package com.example.ultimatesolution.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ultimatesolution.R
import com.example.ultimatesolution.databinding.FragmentContactBinding
import com.example.ultimatesolution.ui.main.MainActivity


class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drawerLayout = MainActivity.getMainActivity()!!.drawerLayout

        binding.toggleDrawerBtn.setOnClickListener {
            //toggle drawer
            if (drawerLayout.isOpen) {
                drawerLayout.close()
            } else
                drawerLayout.open()
        }
    }
}