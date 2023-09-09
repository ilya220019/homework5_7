package vef.ter.homework5_7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import vef.ter.homework5_7.R
import vef.ter.homework5_7.databinding.FragmentNewBinding
import vef.ter.homework5_7.model.WeatherModel
import vef.ter.homework5_7.presenter.Presenter
import vef.ter.homework5_7.view.MainView
import javax.inject.Inject

@AndroidEntryPoint
class NewFragment : Fragment(), MainView {
    private lateinit var binding: FragmentNewBinding
    @Inject
    lateinit var presenter: Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.getWeather()
    }

    override fun showWeather(weatherModel: WeatherModel) {
        binding.tvTemp.text = weatherModel.main.temp.toString() + "°C"
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}