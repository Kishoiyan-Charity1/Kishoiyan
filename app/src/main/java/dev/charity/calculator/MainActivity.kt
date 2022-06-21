package dev.charity.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import dev.charity.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()

    }

    fun castViews(){


        binding.btnAdd.setOnClickListener{
            add(obtainInputs())
        }
        binding.btnSubtract.setOnClickListener{
            subtract(obtainInputs())
        }
        binding.btnModulus.setOnClickListener{
            modulus(obtainInputs())
        }
        binding.btnDivision.setOnClickListener{
            subtract(obtainInputs())
        }

    }
    data class Inputs(var num1:Double, var num2:Double)
    fun obtainInputs(): Inputs? {

        val num1 = binding.etNum1.text.toString()
        val num2 = binding.etNum2.text.toString()
        var error = false

        if (num1.isBlank()) {
            binding.tilNum1.error = "enter a number"
            error = true
        }
        if (num2.isBlank()) {
            binding.tilNum2.error = "enter a number"
            error = true
        }
        if (!error) {
            return Inputs(num1.toDouble(), num2.toDouble())
        }
        return null
    }
    fun add(Inputs: Inputs?){
        if(Inputs!=null) {
            val result= Inputs.num1+Inputs.num2
            binding.tvOutput.text=result.toString()
            }
    }
    fun modulus(Inputs: Inputs?) {
        if(Inputs!=null) {
            val result = Inputs.num1 % Inputs.num2
            binding.tvOutput.text = result.toString()
        }

    }
    fun division(Inputs: Inputs?) {
        if (Inputs!=null){
            val result = Inputs.num1 / Inputs.num2
            binding.tvOutput.text = result.toString()
        }

    }
    fun subtract(Inputs: Inputs?) {
        if (Inputs!=null){
            val result = Inputs.num1 - Inputs.num2
            binding.tvOutput.text = result.toString()
        }
    }
}