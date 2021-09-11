import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.balbugrahan.decksampleclone.R
import com.balbugrahan.decksampleclone.ui.SharedViewModel



class FragmentQuiz : Fragment() {

    lateinit var questionOfQuiz1: TextView //Question
    lateinit var firstAnswer : Button // 1.Answer
    lateinit var secondAnswer : Button // 2.Answer
    lateinit var thirdAnswer : Button // 3.Answer
    lateinit var fourthAnswer : Button // 4.Answer
    lateinit var progressBar: ProgressBar //Circular Bar
    lateinit var progressText :TextView // Circular Bar Count Down Timer Text
    var progress:Int = 0 // Primitive types we can not assign lateinit

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view:View = inflater.inflate(R.layout.fragment_quiz, container, false)

            // We match variable with xml view widget
            questionOfQuiz1 = view.findViewById(R.id.questionText)
            firstAnswer = view.findViewById(R.id.firstAnswerOfQuiz)
            secondAnswer = view.findViewById(R.id.secondAnswerOfQuiz)
            thirdAnswer = view.findViewById(R.id.thirdAnswerOfQuiz)
            fourthAnswer = view.findViewById(R.id.fourthAnswerOfQuiz)

            //ProgressBar
            progressBar= view.findViewById(R.id.progressBarCircle)
            progressText= view.findViewById(R.id.textCountDown)

            return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //calling circular timer
        startTimer()
        // we are creating viewmodel for getting data
        var sharedViewModelInstance1 = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)

        //Getting Question Data
        sharedViewModelInstance1!!.getDataQuestion().observe(viewLifecycleOwner, Observer {

            questionOfQuiz1.text = it
        })

        //Getting Answers Data
        sharedViewModelInstance1!!.getDataAnswers().observe(viewLifecycleOwner, Observer {
            var arrayList: ArrayList<String> = ArrayList<String>()
            arrayList = it.getStringArrayList("mArray") as ArrayList<String>
            // Assigned data from fragment wellcome page
            firstAnswer.setText(arrayList[0])
            secondAnswer.setText(arrayList[1])
            thirdAnswer.setText(arrayList[2])
            fourthAnswer.setText(arrayList[3])

        })

    }

    //CountTimer For ProgressBar
    private fun startTimer(){
        var timer = object: CountDownTimer(20000, 1000){
            override fun onTick(timeLeft: Long) {
                progress = (timeLeft.toInt() / 1000)
                updateProgressBar(progressBar, progressText, progress)
            }
            //When time's up
            override fun onFinish() {
                Toast.makeText(requireContext(), "Time is over", Toast.LENGTH_LONG).show()
            }
        }
        timer.start()
    }

    //Circular Progress Bar Update
    private fun updateProgressBar(progressBar: ProgressBar, progressText: TextView, progress: Int){
        progressBar.progress = progress * 5
        progressText.text = "$progress"
    }

}