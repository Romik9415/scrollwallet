package com.example.scrollwallet.ui.base

import android.os.Bundle
import android.view.View

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.scrollwallet.ui.extentions.addSystemTopAndBottonPadding
import com.example.scrollwallet.ui.navigation.BackButtonListener
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *  Need to rename to "BaseFragment"
 */

@AndroidEntryPoint
abstract class BaseFragment(
    @LayoutRes val contentLayoutId: Int
) : Fragment(contentLayoutId),
    BackButtonListener {

    //protected lateinit var mainComponent: MainComponent

    /*Using for initializing view models with viewModelProvider*/
    abstract fun initViewModel()

    /*Using for triggering inflating finished event*/
    abstract fun onViewReady(inflatedView: View, args: Bundle?)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //todo https://stackoverflow.com/questions/61306719/onactivitycreated-is-deprecated-how-to-properly-use-lifecycleobserver
        super.onActivityCreated(savedInstanceState)
        setListeners()
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view, savedInstanceState)
        setInsetForFragment()
    }

    abstract fun setListeners()

    @Inject
    lateinit var router: Router

    /**
     * Override this method if needed custom back logic
     *
     * Return
     * false -> cancel back btn action
     * true -> need to back action
     */
    override fun onBackPressed(): Boolean {
        router.exit()
        return false
    }

    open fun setInsetForFragment() {
        this.view?.addSystemTopAndBottonPadding()
    }
}