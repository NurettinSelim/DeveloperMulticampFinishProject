package com.nurettinselim.developermulticampfinishproject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurettinselim.developermulticampfinishproject.data.RetroFitProvider
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            val response = RetroFitProvider.myApi.getCommunities()
            val dividerItemDecoration = DividerItemDecoration(
                recyclerViewCommunities.context,
                LinearLayoutManager.VERTICAL
            )
            recyclerViewCommunities.addItemDecoration(dividerItemDecoration)

            recyclerViewCommunities.adapter = CommunityAdapter(response.orEmpty().toMutableList()) {

                val direction = MainFragmentDirections.actionMainFragmentToDetailFragment(it)
                findNavController().navigate(direction)

            }
        }

    }
}
