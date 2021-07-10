package com.example.elizabeth.ui.shoppinglist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.elizabeth.R
import com.example.elizabeth.databinding.FragmentShoppingListFormBinding
import com.example.elizabeth.entity.ShoppingList

class ShoppingListFormFragment : Fragment() {
    private val viewModel: ShoppingListFormViewModel by viewModels()
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
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // listeners
        binding.name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val list = viewModel.list.value
                list?.name = s.toString()
                viewModel.list.setValue(list)
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        // observers
        viewModel.list.observe(viewLifecycleOwner, Observer(fun(it: ShoppingList) {
            binding.name.error = if (it.name.isNotEmpty()) null
            else context?.resources?.getString(R.string.required_field)
        }))
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}