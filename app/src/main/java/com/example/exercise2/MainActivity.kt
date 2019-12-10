package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener(){
            try{
                val weight: Double = editTextWeight.text.toString().toDouble()
                val height: Double = editTextHeight.text.toString().toDouble()
                val bmi: Double = calculateBMI(weight, height.div(100))

                //todo : display image and things
                val status: String
                when {
                    bmi < 18.5 -> {
                        imageViewProfile.setImageResource(R.drawable.under)
                        status = "under"
                    }
                    bmi < 24.9 -> {
                        imageViewProfile.setImageResource(R.drawable.normal)
                        status = "Normal"
                    }
                    else -> {
                        imageViewProfile.setImageResource(R.drawable.over)
                        status = "Over"
                    }
                }
                textViewBMI.text = "BMI %.2f (%s)".format(bmi, status)
            }catch (ex:Exception){
                val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }

        buttonReset.setOnClickListener(){
            imageViewProfile.setImageResource(R.drawable.empty)
            textViewBMI.text=""
            editTextHeight.text.clear()
            editTextWeight.text.clear()

        }

    }
    fun calculateBMI(weight:Double, height:Double):Double{
        //todo:: function to calculate and return BMI
        return weight / Math.pow(height,2.0)
    }

}
