package uz.project.musicplayer.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.project.musicplayer.databinding.MusicItemBinding
import uz.project.musicplayer.model.remote.Model

class MainMusicsAdapter(private val onClick: (Model) -> Unit) :
    ListAdapter<Model, ListViewHolder>(ListViewHolder.CategoryDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        MusicItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ), onClick
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class ListViewHolder(
    private val itemBinding: MusicItemBinding,
    onClick: (Model) -> Unit,
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemView.setOnClickListener {
            currentItem.let(onClick)
        }
    }

    private lateinit var currentItem: Model

    fun bind(item: Model) {
        currentItem = item
        itemBinding.musicPhoto.setImageResource(currentItem.img!!)
        itemBinding.musicName.text = currentItem.musicName
        itemBinding.musicSinger.text = currentItem.singer
    }

    object CategoryDiffCallback : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }
    }

}