package Fragments.Radio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityRadioFragmentBinding

class RadioFragment: Fragment(){
    lateinit var binding:ActivityRadioFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityRadioFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}