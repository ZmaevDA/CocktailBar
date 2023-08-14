package ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.vsu.zmaev.cocktailbar.App
import ru.vsu.zmaev.cocktailbar.databinding.FragmentMyCocktailsBinding
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail
import ru.vsu.zmaev.cocktailbar.presentation.screen.CocktailsViewModelFactory
import ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.adapter.CocktailListAdapter
import ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.viewmodel.MyCocktailsViewModel
import ru.vsu.zmaev.cocktailbar.presentation.state.ScreenState
import ru.vsu.zmaev.cocktailbar.util.collectOnLifecycle
import javax.inject.Inject

class MyCocktailsFragment : Fragment() {

    private var _binding: FragmentMyCocktailsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var vmFactory: CocktailsViewModelFactory

    private lateinit var viewModel: MyCocktailsViewModel

    private val cocktailAdapter = CocktailListAdapter {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().applicationContext as App).appComponent.inject(this)
        _binding = FragmentMyCocktailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            requireActivity(), vmFactory
        )[MyCocktailsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        processFabClick()
        viewModel.screenState.collectOnLifecycle(this) {
            when(it) {
                is ScreenState.Success -> renderSuccess(it.cocktails)
                is ScreenState.Empty -> renderEmptyListScreen()
                is ScreenState.Loading -> renderLoading()
                is ScreenState.Error -> renderError()
            }
        }
        viewModel.getCocktailsList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun processFabClick() {
        binding.addCocktailFab.setOnClickListener {
            val action =
                MyCocktailsFragmentDirections.actionMyCocktailsFragmentToAddCocktailFragment()
            findNavController().navigate(action)
        }
    }

    private fun renderSuccess(cocktails: List<Cocktail>) {
        Log.d("TAG", "renderSuccess: ")
        binding.loadingProgressBar.visibility = View.GONE
        binding.noCocktailsGroup.visibility = View.GONE
        cocktailAdapter.submitList(cocktails)
    }

    private fun renderLoading() {
        Log.d("TAG", "renderLoading: ")
        binding.loadingProgressBar.visibility = View.VISIBLE
    }

    private fun renderError() {
        Log.d("TAG", "renderError: ")
        Toast.makeText(requireContext(), "Err", Toast.LENGTH_SHORT).show()
    }

    private fun renderEmptyListScreen() {
        Log.d("TAG", "renderEmptyListScreen: ")
        binding.noCocktailsGroup.visibility = View.VISIBLE
        binding.loadingProgressBar.visibility = View.GONE
    }

    private fun initViews() {
        binding.cocktailsRv.adapter = cocktailAdapter
    }
}