package app.dpc.kid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.dpc.kid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = "Kid DPC: Ready for Device Owner provisioning."
    }
}
