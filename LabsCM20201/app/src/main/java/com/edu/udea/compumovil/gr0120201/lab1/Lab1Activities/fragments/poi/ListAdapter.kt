package com.edu.udea.compumovil.gr0120201.lab1.Lab1Activities.fragments.poi

import android.graphics.BitmapFactory
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.edu.udea.compumovil.gr0120201.lab1.Lab1Activities.models.Poi
import com.edu.udea.compumovil.gr0120201.lab1.R
import kotlinx.android.synthetic.main.poi_row.view.*
import java.io.File


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var poiList = emptyList<Poi>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.poi_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return poiList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = poiList[position]
        var imageResource:Int

        when(position){
            0->imageResource = R.drawable.catedral_cove
            1->imageResource = R.drawable.hobbitonen_nueva_zelanda
            2->imageResource = R.drawable.parque_nacional_tongariro
            3->imageResource = R.drawable.wai_o_tapu
            else ->{ imageResource = R.drawable.catedral_cove}
        }
        holder.itemView.title_txt.text = currentItem.title
        holder.itemView.imageView.setImageResource(imageResource)
        //holder.itemView.description_txt.text = currentItem.description
        //holder.itemView.location_txt.text = currentItem.location
        //holder.itemView.imageView.setImageDrawable(ContextCompat.getDrawable())
        holder.itemView.rowLayout.setOnClickListener {
            val action = PoiListFragmentDirections.actionPoiListFragmentToPoiDetail(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

        fun setData(poi: List<Poi>) {
            this.poiList = poi
            notifyDataSetChanged()
        }
}