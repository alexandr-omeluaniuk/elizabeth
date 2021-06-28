package com.example.elizabeth.ui.shoppinglist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.elizabeth.databinding.FragmentShoppingListFormBinding
import com.example.elizabeth.databinding.FragmentShoppingListsBinding
import com.google.android.material.snackbar.Snackbar

class ShoppingListFormFragment : Fragment() {
    private lateinit var viewModel: ShoppingListFormViewModel
    private var _binding: FragmentShoppingListFormBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingListFormBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel = ViewModelProvider(this).get(ShoppingListFormViewModel::class.java)
        viewModel.list.observe(viewLifecycleOwner, Observer {
            System.out.println("-> " + it.name);
            binding.name.setText(it.name)
            binding.name.error = if (!it.name.isEmpty()) null else "Required"
        })
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validate(): Boolean {
        val name = binding.name.text
        return true
    }
}