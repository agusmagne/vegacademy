package com.vegdev.vegacademy.view.main.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import com.vegdev.vegacademy.model.data.models.User
import com.vegdev.vegacademy.view.BaseView

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun onVideoClicked(url: String)
    fun openYoutubePlayer(minHeight: Int)
    fun closeYoutubePlayer()
    fun showNavView()
    fun hideNavView()
    fun getCurrentFragment(): Fragment?
    fun navigateToDirection(direction: NavDirections)
    fun makeToast(message: String)
    fun onBackPressed()
    fun showWebProgressbar()
    fun hideWebProgressbar()
    fun navigateWithOptions(
        navigationId: Int,
        bundle: Bundle,
        options: NavOptions,
        extras: FragmentNavigator.Extras
    )
}