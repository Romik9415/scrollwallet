package com.example.scrollwallet.ui.pages.home

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.HomeFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.dp
import com.example.scrollwallet.ui.extentions.logd
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.example.scrollwallet.ui.navigation.Screens
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.robinhood.ticker.TickerUtils
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment(R.layout.home_fragment), OnClickListener {
    val binding by viewBindingWithBinder(HomeFragmentBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun initViewModel() {
        viewModel.currentRollsLiveData.observe(this) {
            binding.tvUserDescription.text = getBalanceString(it?.rolls)
        }
    }

    val CORNER_SHRINK_RANGE = 0.15f

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        binding.tvUserDescription.apply {
            setCharacterLists(TickerUtils.provideNumberList())
            animationDuration = 800
        }
        val pageAdapter = ProfileViewPagerAdapter(this)
        setViewPager(pageAdapter)
        //binding.ivPhotoGalery.loadWithGlide("https://gadgetmates.com/wp-content/uploads/2024/02/image-116.jpeg")
        val viewToGrow: View = binding.tlLocation
        val baseTopPadding = viewToGrow.paddingTop

//        val topInsets = binding.llToolbar.paddingTop
//        val toolbarHeight = binding.llToolbar.measuredHeight

        // Determine how much top padding has to grow while the app bar scrolls.
        //var maxDeltaPadding = toolbarHeight + topInsets + toolbarHeight
        val maxDeltaPadding = 110.dp
        logd("LocationFragment::", "maxDeltaPadding: $maxDeltaPadding")
        //val contentView = findViewById<View>(android.R.id.content)
//        val contentView = binding.tlLocation
//        ViewCompat.setOnApplyWindowInsetsListener(contentView) { _, insets ->
//            maxDeltaPadding = insets.systemWindowInsetTop
//            insets
//        }

        // Get key metrics for corner radius shrikage.
        var backgroundRadii: FloatArray? = null
        var maxRadius: FloatArray? = null
        //val backgroundDrawable = (viewToGrow.background as GradientDrawable?)
//        if (backgroundDrawable != null) {
//            backgroundRadii = backgroundDrawable.cornerRadii
//            maxRadius = floatArrayOf(backgroundRadii!![0], backgroundRadii[1])
//        }

        // Set up the app bar and the offset change listener.
        val appBar: AppBarLayout = binding.appBarDetailPlace
        val appBarTotalScrollRange: Float by lazy {
            appBar.totalScrollRange.toFloat()
        }
        //logd("LocationFragment::", "appBarTotalScrollRange: $appBarTotalScrollRange")
        appBar.addOnOffsetChangedListener { _, verticalOffset ->
            // Add/remove padding gradually as the appbar scrolls.
            val percentOfScrollRange = (-verticalOffset / appBarTotalScrollRange)
            logd("LocationFragment::", "percentOfScrollRange: $percentOfScrollRange")
            val deltaPadding = maxDeltaPadding * percentOfScrollRange
            logd("LocationFragment::", "deltaPadding: $deltaPadding")
            val newTopPadding = baseTopPadding + deltaPadding.toInt()
            logd("LocationFragment::", "newTopPadding: $newTopPadding")
            if (newTopPadding != viewToGrow.paddingTop) {
                viewToGrow.setPadding(
                    viewToGrow.paddingLeft,
                    newTopPadding,
                    viewToGrow.paddingRight,
                    viewToGrow.paddingBottom
                )
                // Change the drawable radius as the appbar scrolls.
                if (backgroundRadii != null && maxRadius != null) {
                    val radiusShrinkage = if (percentOfScrollRange > (1.0f - CORNER_SHRINK_RANGE)) {
                        (1.0f - percentOfScrollRange) / CORNER_SHRINK_RANGE
                    } else {
                        1.0f
                    }
                    backgroundRadii[0] = maxRadius[0] * radiusShrinkage
                    backgroundRadii[1] = maxRadius[1] * radiusShrinkage
                    backgroundRadii[2] = maxRadius[0] * radiusShrinkage
                    backgroundRadii[3] = maxRadius[1] * radiusShrinkage
                    //backgroundDrawable!!.cornerRadii = backgroundRadii
                }
            }
        }
    }

    override fun setListeners() {
        binding.ivSettings.setOnClickListener(this)
        binding.ivNotifications.setOnClickListener(this)
        binding.cvRoll.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivNotifications -> router.navigateTo(Screens.navigateToNotificationScreen())
            binding.ivSettings -> router.navigateTo(Screens.navigateToSettingsScreen())
            binding.cvRoll -> router.navigateTo(Screens.navigateToScrollScreen())
        }

    }

    private fun setViewPager(pageAdapter: ProfileViewPagerAdapter) {
        with(binding.vp2Location) {
            adapter = pageAdapter
        }
        TabLayoutMediator(
            binding.tlLocation, binding.vp2Location
        ) { tab, position ->
            tab.text = binding.root.context.getString(pageAdapter.listOFragments[position].first)
        }.attach()
    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }

    private fun getBalanceString(currentRollBalance: Double?): String {
        if (currentRollBalance == null) return "0.000 ROLL"
        return String.format("%.3f", currentRollBalance) + " ROLL"
    }
}