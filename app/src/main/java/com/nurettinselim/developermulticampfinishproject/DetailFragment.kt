package com.nurettinselim.developermulticampfinishproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bannerImage.load(args.community.banner)
        descriptionText.text = args.community.description
        leaderPhoto.load(args.community.leader?.photo)
        leaderName.text = args.community.leader?.name

        instagramButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(args.community.links?.instagram))
            startActivity(i)
        }
        twitterButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(args.community.links?.twitter))
            startActivity(i)
        }
        youtubeButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(args.community.links?.youtube))
            startActivity(i)
        }
        participationButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(args.community.links?.participation))
            startActivity(i)
        }
    }

}
