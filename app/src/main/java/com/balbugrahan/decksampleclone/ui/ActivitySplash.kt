package com.balbugrahan.decksampleclone.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.balbugrahan.decksampleclone.R
import java.util.*
import com.balbugrahan.decksampleclone.util.startActivity

class ActivitySplash : AppCompatActivity() {

    private val DELAY  :  Long = 3 * 1000 //Splash delay time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Timer for splash activity
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<ActivityMain>{
                    Intent().putExtra("name", "ali")
                }
            }
        }, DELAY)
    }
}
