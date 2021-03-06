package com.example.elizabeth.ui.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.elizabeth.R
import com.example.elizabeth.databinding.FragmentShoppingListsBinding
import com.google.android.material.snackbar.Snackbar

class ShoppingListFragment : Fragment() {

    private lateinit var shoppingListViewModel: ShoppingListViewModel
    private var _binding: FragmentShoppingListsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoppingListViewModel =
            ViewModelProvider(this).get(ShoppingListViewModel::class.java)

        _binding = FragmentShoppingListsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(R.id.nav_shopping_list_form)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}