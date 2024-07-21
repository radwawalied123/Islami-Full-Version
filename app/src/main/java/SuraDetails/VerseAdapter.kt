package SuraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemSuraBinding
import com.example.islami.databinding.ItemSuraVerseBinding

class VerseAdapter(private val verse: List<String>) :
    RecyclerView.Adapter<VerseAdapter.SuraViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseAdapter.SuraViewHolder {
        val viewBinding: ItemSuraVerseBinding = ItemSuraVerseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return SuraViewHolder(viewBinding)
    }


    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        val aya = verse[position]
        holder.itemBinding.verseContent.text = aya
    }

    override fun getItemCount(): Int = verse.size
    class SuraViewHolder(val itemBinding: ItemSuraVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(title: String, position: Int)

    }

}