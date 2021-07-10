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
import com.example.elizabeth.model.ShoppingList
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
            System.out.println("-> " + it.name.get());
            val n = it.name.get()
            binding.name.error = if (n != null && n.isNotEmpty()) null else "Required"
        })
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // listeners
        binding.name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val list = viewModel.list.getValue()
                list?.name?.set(s.toString())
                viewModel.list.setValue(list)
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}