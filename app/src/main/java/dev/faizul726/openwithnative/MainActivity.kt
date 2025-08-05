package dev.faizul726.openwithnative

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var url = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (!url?.startsWith("http://")!! && !url.startsWith("https://")) {
            url = "http://$url"
        }
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    url.toUri()
                )/*.apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }*/
            )
        } catch (e: Exception) {
            Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_SHORT).show()
        }
        finishAffinity()
    }
}