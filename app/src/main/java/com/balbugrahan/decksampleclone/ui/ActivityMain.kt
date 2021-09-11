package com.balbugrahan.decksampleclone.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.balbugrahan.decksampleclone.R

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //We are pushing FragmentWelcome via Fragment Manager Method
        //Not best practise we could use section adapter or navigation fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val firstFragment = FragmentWelcome()
        fragmentTransaction.replace(R.id.frame_layout, firstFragment).commit()
    }
}