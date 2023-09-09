package vef.ter.homework5_7.view

import vef.ter.homework5_7.model.WeatherModel

interface MainView {
    fun showWeather(weatherModel: WeatherModel)
    fun showError(message: String)
}