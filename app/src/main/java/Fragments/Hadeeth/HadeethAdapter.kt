package Fragments.Hadeeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadeethBinding

class HadeethAdapter(private val hadeethList: List<String>) :
    RecyclerView.Adapter<HadeethAdapter.HadeethViewHolder>() {
    class HadeethViewHolder(val itemBinding: ItemHadeethBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeethViewHolder {
        val viewBinding: ItemHadeethBinding =
            ItemHadeethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadeethViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadeethList.size

    override fun onBindViewHolder(holder: HadeethViewHolder, position: Int) {
        val title = hadeethList[position]
        holder.itemBinding.hadeethTitle.text = title
    }
}