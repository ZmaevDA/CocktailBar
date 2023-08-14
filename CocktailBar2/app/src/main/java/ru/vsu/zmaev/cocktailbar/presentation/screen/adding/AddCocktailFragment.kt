package ru.vsu.zmaev.cocktailbar.presentation.screen.adding

import android.app.ActionBar
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import ru.vsu.zmaev.cocktailbar.App
import ru.vsu.zmaev.cocktailbar.databinding.DialogAddIgredientBinding
import ru.vsu.zmaev.cocktailbar.databinding.FragmentAddCocktailBinding
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.presentation.screen.CocktailsViewModelFactory
import ru.vsu.zmaev.cocktailbar.presentation.screen.adding.viewmodel.AddCocktailViewModel
import javax.inject.Inject


class AddCocktailFragment : Fragment() {

    private var _binding: FragmentAddCocktailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var vmFactory: CocktailsViewModelFactory

    private lateinit var viewModel: AddCocktailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.inject(this)
        _binding = FragmentAddCocktailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            requireActivity(), vmFactory
        )[AddCocktailViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processAddChipButton()
        processSaveButton()
        processCancelButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addChip(text: String) {
        val chip = Chip(requireContext())
        chip.text = text
        chip.isCloseIconVisible = true

        chip.setOnCloseIconClickListener {
            binding.ingredientsCg.removeView(chip)
        }
        binding.ingredientsCg.addView(chip)
    }

    private fun getChips(): MutableList<String> {
        val chipList = mutableListOf<String>()

        for (i in 0 until binding.ingredientsCg.childCount) {
            val chip = binding.ingredientsCg.getChildAt(i) as? Chip
            chip?.let {
                chipList.add(it.text.toString())
            }
        }
        return chipList
    }

    private fun processSaveButton() {
        binding.saveCocktailButton.setOnClickListener {
            val title = binding.titleEditTil.editText?.text.toString()
            val description = binding.descriptionTil.editText?.text.toString()
            val recipe = binding.recipeTil.editText?.text.toString()
            if (inputCheck(title, description, recipe)) {
                val uri = Uri.parse("android.resource://your.package.here/drawable/cocktail_sample")
                viewModel.addCocktail(
                    Cocktail(
                        id = 0,
                        name = title,
                        description = description,
                        recipe = recipe,
                        ingredients = getChips(),
                        imagePath = uri.toString()
                    )
                )
                findNavController().popBackStack()
            }
        }
    }

    private fun processCancelButton() {
        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun processAddChipButton() {
        binding.addIngredientChip.setOnClickListener {
            showAddIngredientDialog()
        }
    }

    private fun showAddIngredientDialog() {
        val dialog = Dialog(requireContext())
        val dialogBinding = DialogAddIgredientBinding.inflate(layoutInflater, null, false)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        dialog.window?.setLayout(width, ActionBar.LayoutParams.WRAP_CONTENT)
        dialogBinding.addButton.setOnClickListener {
            addChip(dialogBinding.titleEt.editText?.text.toString())
            dialog.dismiss()
            getChips()
        }
        dialogBinding.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun inputCheck(
        title: String,
        description: String,
        recipe: String
        ): Boolean {
        return viewModel.inputCheck(title, description, recipe)
    }
}