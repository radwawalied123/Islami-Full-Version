package SuraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {
    var suraIndex: Int = 0
    lateinit var suraTitle: String
    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        suraTitle = intent.getStringExtra(Constants.suraTitle) ?: ""
        suraIndex = intent.getIntExtra(Constants.suraIndex, 0) + 1
        initViews()
        readSura()
    }
//to activate the toolbar back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun readSura() {
        val inputStream = assets.open("$suraIndex.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        val numberedLines = mutableListOf<String>()
        val maxLineNumberLength = lines.size.toString().length // Calculate the maximum length of line number
        for ((index, line) in lines.withIndex()) {
            val lineNumber = "{${(index + 1).toString().padStart(maxLineNumberLength, ' ')}}" // Format line number with curly braces and pad to fixed width
            val numberedLine = "$line $lineNumber" // Concatenate line and line number
            println("$numberedLine") // Print the line and its corresponding number
            numberedLines.add(numberedLine)
        }
        initRecyclerView(numberedLines)
    }


    private fun initRecyclerView(verse: List<String>) {
        val adapter = VerseAdapter(verse)
        binding.content.rvSuraVerse.adapter = adapter

    }

    private fun initViews() {
        setTitle(null)
        binding.tvIslami.text = suraTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}