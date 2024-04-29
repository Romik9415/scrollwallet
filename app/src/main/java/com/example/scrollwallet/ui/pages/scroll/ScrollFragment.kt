package com.example.scrollwallet.ui.pages.scroll

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollwallet.R
import com.example.scrollwallet.data.dto.Scroll
import com.example.scrollwallet.databinding.ScrollFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.logd
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.example.scrollwallet.ui.navigation.Screens
import com.example.scrollwallet.ui.pages.home.tokens.ReservationAdapter
import com.robinhood.ticker.TickerUtils
import kotlinx.coroutines.launch

class ScrollFragment : BaseFragment(R.layout.scroll_fragment), View.OnClickListener {
    private val viewModel: ScrollViewModel by viewModels()

    private val binding by viewBindingWithBinder(ScrollFragmentBinding::bind)
    private var reservationAdapter = ScrollAdapter()

    override fun initViewModel() {
        viewModel.currentRollsLiveData.observe(this) {
            binding.tvUserDescription2.text = getBalanceString(it?.rolls)
        }
    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        binding.tvUserDescription2.apply {
            setCharacterLists(TickerUtils.provideNumberList())
            animationDuration = 800
        }
        var oldFirstPos = -1
        var oldLastPos = -1
        var totalItemsViewed = 0

        with(binding.rvScroll) {
            adapter = reservationAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val currFirstPos =
                        (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                    val currLastPos =
                        (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

                    totalItemsViewed += when (oldFirstPos) {
                        -1 -> currLastPos - currFirstPos + 1
                        else -> when {
                            dy > 0 -> Math.abs(currLastPos - oldLastPos) //scrolling to bottom
                            else -> Math.abs(currFirstPos - oldFirstPos) //scrolling to top
                        }
                    }

                    oldLastPos = currLastPos
                    oldFirstPos = currFirstPos

                    lifecycleScope.launch {
                        viewModel.updateRolls(totalItemsViewed)
                    }
                }
            })

        }
        val list = mutableListOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
            81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            91, 92, 93, 94, 95, 96, 97, 98, 99, 100
        ).map { Scroll(it) }
        reservationAdapter.submitList(list)
    }

    override fun setListeners() {
        binding.ivBack.setOnClickListener(this)
        binding.tvUserDescription3.setOnClickListener(this)
    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivBack -> router.exit()
            binding.tvUserDescription3 -> {
                router.navigateTo(Screens.openUrl("https://t.me/covalenthqann"))
            }
        }
    }

    private fun getBalanceString(currentRollBalance: Double?): String {
        if (currentRollBalance == null) return "0.000 ROLL"
        return String.format("%.3f", currentRollBalance) + " ROLL"
    }
}