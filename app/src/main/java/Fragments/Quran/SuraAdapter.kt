package Fragments.Quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemSuraBinding

class SuraAdapter(private val suraList: List<String>) :
    RecyclerView.Adapter<SuraAdapter.SuraViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraAdapter.SuraViewHolder {
        val viewBinding: ItemSuraBinding = ItemSuraBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return SuraViewHolder(viewBinding)
    }


    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        val title = suraList[position]
        val index = position + 1
        holder.itemBinding.suraTitle.text = title
        holder.itemBinding.suraIndex.text = index.toString()
        onItemClickListener.let {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(title, position)
            }
        }


    }

    override fun getItemCount(): Int = suraList.size
    class SuraViewHolder(val itemBinding: ItemSuraBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(title: String, position: Int)

    }

}