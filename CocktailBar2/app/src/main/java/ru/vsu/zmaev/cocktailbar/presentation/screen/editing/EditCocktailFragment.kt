package ru.vsu.zmaev.cocktailbar.presentation.screen.editing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vsu.zmaev.cocktailbar.databinding.FragmentEditCocktailBinding

class EditCocktailFragment() : Fragment() {

    private var _binding: FragmentEditCocktailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditCocktailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}