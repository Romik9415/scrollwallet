package com.example.scrollwallet.ui.pages.scroll

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollwallet.R
import com.example.scrollwallet.data.dto.Scroll
import com.example.scrollwallet.databinding.ScrollFragmentBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.addSystemTopPadding
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder
import com.example.scrollwallet.ui.navigation.Screens
import com.robinhood.ticker.TickerUtils
import kotlinx.coroutines.launch

class ScrollFragment : BaseFragment(R.layout.scroll_fragment), View.OnClickListener {
    private val viewModel: ScrollViewModel by viewModels()

    private val binding by viewBindingWithBinder(ScrollFragmentBinding::bind)
    private var reservationAdapter = ScrollAdapter()

    override fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.currentRollsLiveData.collect {
                    binding.tvUserDescription2.text = getBalanceString(it?.rolls)
                }
            }
        }
    }

    private var itemsScrolled = 0
    private var lastVisibleItemPosition = 0
    var userEnergy = 1000

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        binding.tvUserDescription2.apply {
            setCharacterLists(TickerUtils.provideNumberList())
            animationDuration = 800
        }

        with(binding.rvScroll) {
            adapter = reservationAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                    if (firstVisibleItemPosition + visibleItemCount >= totalItemCount) {
                        // We're at the end of the list, no need to update the item count
                        return
                    }

                    val newLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                    if (newLastVisibleItemPosition > lastVisibleItemPosition) {
                        itemsScrolled += newLastVisibleItemPosition - lastVisibleItemPosition
                        lastVisibleItemPosition = newLastVisibleItemPosition
                        updateScrolledItemsCount(itemsScrolled)
                    }
                }
            })
        }

        val items = getItems()
        reservationAdapter.submitList(items)
    }

    private fun getItems(): List<Scroll> {
        val baseItems = (0..userEnergy).map { Scroll(it, null) }
        baseItems.mapIndexed { index, scroll ->
            if (index % 25 == 0) {
                scroll.text = "+25 ROLL \uD83E\uDE99"
            }
            if (index % 50 == 0) {
                scroll.text = "Here you can leave your ad"
            }
            if (index % 100 == 0) {
                scroll.text = "WOW! You are the best!"
            }
        }
        baseItems.firstOrNull()?.text =
            "Just scroll to get ROLL coins \uD83D\uDE4C\uD83C\uDFB2\uD83D\uDD25\uD83D\uDE80"
        return baseItems
    }

    override fun setListeners() {
        binding.ivBack.setOnClickListener(this)
        binding.clEarn.setOnClickListener(this)
        //binding.tvUserDescription3.setOnClickListener(this)
    }

    override fun setInsetForFragment() {
        binding.llToolbar.addSystemTopPadding()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.ivBack -> router.exit()
            binding.clEarn -> {
                router.navigateTo(Screens.navigateToEarnScreen())
            }
//            binding.tvUserDescription3 -> {
//                router.navigateTo(Screens.openUrl("https://t.me/covalenthqann"))
//            }
        }
    }

    private fun updateScrolledItemsCount(count: Int) {
        // Update the UI or perform any other operations with the count value
        // For example, you can update a TextView with the count value
        val textView = binding.tvToolbarTitle
        textView.text = "Items scrolled: $count"
        decriesEnergy()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.rollsIncrease()
        }
    }

    private fun decriesEnergy() {
        userEnergy -= 1
        binding.tvEnergyCurrent.text = userEnergy.toString()
        binding.piEnergy.progress = userEnergy
    }

    private fun getBalanceString(currentRollBalance: Double?): String {
        if (currentRollBalance == null) return "0.000 ROLL"
        return String.format("%.3f", currentRollBalance) + " ROLL"
    }
}