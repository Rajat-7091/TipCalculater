package com.example.tipcalculater
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculater.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

private var TextInputLayout.text: String
    get() {
        return this.editText?.text.toString()
    }
    set(value) = this.editText?.setText(value)!!
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInField = binding.textInputLayout.text
        val cost = stringInField.toFloat()
        val selectedId = binding.tipOption.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.radioButtonAmazing -> 0.20
            R.id.radioButtonGood -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        binding.tipAmount.text = tip.toString()
    }
}