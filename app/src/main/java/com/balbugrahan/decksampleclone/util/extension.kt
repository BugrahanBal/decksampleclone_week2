package com.balbugrahan.decksampleclone.util

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.balbugrahan.decksampleclone.R
import kotlinx.android.synthetic.main.activity_main.view.*

inline fun<reified T : AppCompatActivity> Context.startActivity(block : Intent.() -> Unit = {}){
    //Generic intent extensions
    val intent  = Intent(this , T::class.java)
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(
            intent.also {
                block.invoke(it)
            }
    )
}

inline fun FragmentManager.toGoOtherFragment(blocks: FragmentTransaction.()->Unit) {
    //Extensions for fragment to fragment transaction
    val fragmentTransaction =beginTransaction()
    fragmentTransaction.blocks()
    fragmentTransaction.commit()
    /* val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
     val fragmentTransaction = fragmentManager.beginTransaction()
     val fragmentQuiz = FragmentQuiz()
    fragmentTransaction.replace(R.id.frame_layout, fragmentQuiz).commit()*/
}
