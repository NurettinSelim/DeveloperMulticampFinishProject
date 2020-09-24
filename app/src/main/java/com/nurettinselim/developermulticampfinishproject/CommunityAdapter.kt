package com.nurettinselim.developermulticampfinishproject


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nurettinselim.developermulticampfinishproject.data.model.Community
import kotlinx.android.synthetic.main.item_community.view.*


class CommunityAdapter(
    private val communityList: MutableList<Community>,
    private val onClick: (Community) -> Unit
) :
    RecyclerView.Adapter<CommunityViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CommunityViewHolder(inflater.inflate(R.layout.item_community, parent, false))
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val community = communityList[position]
        holder.bind(community, onClick)
    }

    override fun getItemCount(): Int = communityList.size

}

class CommunityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(community: Community, onClick: (Community) -> Unit) {
        itemView.bannerImage.load(community.banner)

        itemView.setOnClickListener {
            onClick(community)
        }
    }
}