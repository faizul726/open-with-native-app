package dev.faizul726.openwithnative

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var url: String? = null
        
        when(intent?.action) {
            Intent.ACTION_SEND -> {
                url = intent.getStringExtra(Intent.EXTRA_TEXT)
            }
            Intent.ACTION_PROCESS_TEXT -> {
                url = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT)
            }
        }
        if (!url.isNullOrBlank()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://$url"
            }
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        url.toUri()
                    )
                )
            } catch (e: Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        finishAffinity()
    }
}
