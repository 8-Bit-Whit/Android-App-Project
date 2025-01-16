package edu.msudenver.cs3013.project2_s24

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//this is the adapter for the recycler view
class APODAdapter : RecyclerView.Adapter<APODAdapter.APODViewHolder>() {

    private var apodItems: List<ApodItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APODViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_apod, parent, false)
        return APODViewHolder(view)
    }

    override fun onBindViewHolder(holder: APODViewHolder, position: Int) {
        val apodItem = apodItems[position]
        holder.bind(apodItem)
    }

    override fun getItemCount(): Int = apodItems.size

    fun submitList(items: List<ApodItem>) {
        apodItems = items
        notifyDataSetChanged()
    }

    class APODViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.apodTitleTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.apodDateTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.apodImageView)

        fun bind(apodItem: ApodItem) {
            titleTextView.text = apodItem.title
            dateTextView.text = apodItem.date
            Glide.with(itemView.context)
                .load(apodItem.url)
                .into(imageView)
        }
    }
}