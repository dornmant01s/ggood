package app.dpc.kid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import app.dpc.kid.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView).text =
            "Kid DPC: Ready for Device Owner provisioning."
    }
}
