package Fragments.Sebha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivitySebhaFragmentBinding

class SebhaFragment : Fragment(){
    lateinit var binding:ActivitySebhaFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivitySebhaFragmentBinding.inflate(inflater,container,false )
        return binding.root
    }

}