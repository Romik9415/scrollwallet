package com.example.scrollwallet.ui.pages.home.liked

import android.os.Bundle
import android.view.View
import com.example.scrollwallet.R
import com.example.scrollwallet.databinding.FragmentOwnedBinding
import com.example.scrollwallet.ui.base.BaseFragment
import com.example.scrollwallet.ui.extentions.GridSpacingItemDecoration
import com.example.scrollwallet.ui.extentions.dp
import com.example.scrollwallet.ui.extentions.viewBindingWithBinder

class LikedFragment : BaseFragment(R.layout.fragment_owned), OnNftClicked {

    private val binding by viewBindingWithBinder(FragmentOwnedBinding::bind)
    private var nftCollectionAdapter = DropsCollectionsAdapter(this)
    private val dividerDecorator = GridSpacingItemDecoration(2, 8.dp, false)

    override fun initViewModel() {}

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        with(binding.recyclerView) {
            adapter = nftCollectionAdapter
            addItemDecoration(dividerDecorator)
        }
        nftCollectionAdapter.submitList(listOfNft)
    }

    override fun setListeners() {

    }

    override fun setInsetForFragment() {
    }

    private val listOfNft = listOf(
        NftCollectionItem(
            1,
            "https://bucket-bykvu.s3.eu-central-1.amazonaws.com/wp-content/uploads/2022/01/https___hypebeast.com_image_2022_01_eminem-bored-ape-yacht-club-nft-450000-usd-purchase-001.jpg",
            "",
            ""
        ),
        NftCollectionItem(
            2,
            "https://i.pinimg.com/564x/2a/73/96/2a7396560b472d474f2c94f3a205bdb2.jpg",
            "",
            ""
        ),
        NftCollectionItem(
            3,
            "https://idsb.tmgrup.com.tr/ly/uploads/images/2021/03/23/102271.jpg",
            "",
            ""
        ),
        NftCollectionItem(
            4,
            "https://bucket-bykvu.s3.eu-central-1.amazonaws.com/wp-content/uploads/2022/01/https___hypebeast.com_image_2022_01_eminem-bored-ape-yacht-club-nft-450000-usd-purchase-001.jpg",
            "",
            ""
        ),
        NftCollectionItem(
            5,
            "https://i.pinimg.com/564x/2a/73/96/2a7396560b472d474f2c94f3a205bdb2.jpg",
            "",
            ""
        ),
        NftCollectionItem(
            6,
            "https://idsb.tmgrup.com.tr/ly/uploads/images/2021/03/23/102271.jpg",
            "",
            ""
        )
    )

    override fun onItemClicked() {
        //router.navigateTo(Screens.openNFTDetails(""))
    }
}