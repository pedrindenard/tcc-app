package com.uri.tcc.feature.presentation.activity.home

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.uri.tcc.R
import com.uri.tcc.databinding.ActivityHomeBinding
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.presentation.activity.login.LoginActivity

class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavController()
    }

    private fun setNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.home_nav_controller) as NavHostFragment
        val navController = navHostFragment.navController
        setNavMenu(navController)
        setListener(navController)
    }

    private fun setNavMenu(navController: NavController) {
        binding.homeBottomNav.setupWithNavController(navController)
        binding.homeBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    navigateTo(navController, R.id.home_fragment)
                }
                R.id.menu_tcc -> {
                    navigateTo(navController, R.id.tcc_fragment)
                }
                R.id.menu_library -> {
                    navigateTo(navController, R.id.library_fragment)
                }
                R.id.menu_profile -> {
                    navigateTo(navController, R.id.profile_fragment)
                }
                R.id.menu_logout -> {
                   SharedPreferencesImpl(this).apply {
                       remove(SharedPreferencesImpl.Setting.USER_TOKEN)

                       val intent = Intent(binding.root.context, LoginActivity::class.java)
                       intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                            Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                       )

                       startActivity(intent)
                   }
                }
            }
            true
        }
    }

    private fun setMenuSelectable(destination: NavDestination) {
        when (destination.id) {
            R.id.home_fragment -> {
                binding.homeBottomNav.menu.getItem(0).isChecked = true
            }
            R.id.tcc_fragment -> {
                binding.homeBottomNav.menu.getItem(1).isChecked = true
            }
            R.id.library_fragment -> {
                binding.homeBottomNav.menu.getItem(2).isChecked = true
            }
            R.id.profile_fragment -> {
                binding.homeBottomNav.menu.getItem(3).isChecked = true
            }
        }
    }

    private fun setListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            setMenuSelectable(destination)
            setOrientation()
        }
    }

    private fun setOrientation() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
    }

    private fun navigateTo(navController: NavController, fragment: Int) {
        if (fragment != navController.currentDestination?.id) {
            if (fragment != R.id.home_fragment) {
                navController.navigate(fragment, null, getNavOptions(fragment))
            } else {
                navController.popBackStack()
            }
        }
    }

    private fun getNavOptions(fragment: Int): NavOptions {
        val navOptions = NavOptions.Builder()

        navOptions.setEnterAnim(R.anim.anim_fade_in)
        navOptions.setExitAnim(R.anim.anim_fade_out)
        navOptions.setPopEnterAnim(R.anim.anim_fade_in)
        navOptions.setPopExitAnim(R.anim.anim_fade_out)

        navOptions.setPopUpTo(R.id.home_fragment, fragment == R.id.home_fragment)

        return navOptions.build()
    }
}