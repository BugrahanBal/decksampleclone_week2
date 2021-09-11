package com.balbugrahan.decksampleclone.ui
import FragmentQuiz
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.balbugrahan.decksampleclone.R
import com.balbugrahan.decksampleclone.util.toGoOtherFragment

class FragmentWelcome : Fragment() {

    var question:String ="Visualize"  //Question
    var answersArray = arrayListOf<String>("Görselleştirmek", "Altında", "Bağış", "Ensülin") //Answers
    val mBundle = Bundle() // We are creating bundle for answer array transfer
    lateinit var button:Button
    lateinit var sharedViewModelInstance: SharedViewModel // Created for data transfer fragment to fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBundle.putStringArrayList("mArray", answersArray) // ArrayList put in Bundle
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_welcome, container, false)
        //button match layout
        button =view.findViewById(R.id.buttonSimdiBasla)
        return view }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            //created for transfer another fragment
            requireActivity().supportFragmentManager.toGoOtherFragment {
                val fragmentQuiz = FragmentQuiz()
                replace(R.id.frame_layout, fragmentQuiz)
            }
            //We are creating viewmodel instance for setting data that we would like to transfer
            sharedViewModelInstance = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            sharedViewModelInstance?.setDataQuestion(question)
            sharedViewModelInstance?.setDataAnswers(mBundle)

        }
    }
}