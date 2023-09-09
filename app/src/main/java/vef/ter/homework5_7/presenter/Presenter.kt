package vef.ter.homework5_7.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vef.ter.homework5_7.model.WeatherApi
import vef.ter.homework5_7.model.WeatherModel
import vef.ter.homework5_7.view.MainView
import javax.inject.Inject

class Presenter @Inject constructor(private val weatherApi: WeatherApi) {
    private lateinit var mainView: MainView
    fun getWeather() {
        weatherApi.getWeather().enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let { mainView.showWeather(it) }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

        })
    }

    fun attachView(mainView: MainView) {
        this.mainView = mainView
    }

}