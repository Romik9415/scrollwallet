package com.example.scrollwallet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.scrollwallet.databinding.ActivityMainBinding
import com.example.scrollwallet.ui.extentions.viewBinding
import com.example.scrollwallet.ui.navigation.BackButtonListener
import com.example.scrollwallet.ui.navigation.Screens
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy {
        object : AppNavigator(this, R.id.flMainNavigationContainer) {
            override fun setupFragmentTransaction(
                screen: FragmentScreen,
                fragmentTransaction: FragmentTransaction,
                currentFragment: Fragment?,
                nextFragment: Fragment
            ) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.fragment_open_enter,
                    R.anim.fragment_open_exit,
                    R.anim.fragment_close_enter,
                    R.anim.fragment_close_exit
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val isLoggedIn = true
        //if (authSessionManager.isUserLoggedIn()) {
        if (savedInstanceState == null) {
            if (isLoggedIn) {
                navigator.applyCommands(arrayOf<Command>(Replace(Screens.navigateHomeScreen())))
            } else {
                navigator.applyCommands(arrayOf<Command>(Replace(Screens.navigateStartScreen())))
            }
        }
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }


    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val fm = supportFragmentManager
        var fragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
        if (
            fragment != null && fragment is BackButtonListener &&
            !(fragment as BackButtonListener).onBackPressed()
        ) {
            return
        } else {
            router.exit()
        }
    }
}