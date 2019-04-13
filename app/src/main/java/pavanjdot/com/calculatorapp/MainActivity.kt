package pavanjdot.com.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private enum class OPERATOR{
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    //Instance Variable
    private  var currentNumber: String? = null
    private var currentOperator: OPERATOR? =null
    private var stringNumberAtLeft: String? = null
    private var stringNumberAtRight: String? = null
    private var calculationResult: Double = 0.0
    private var calculationString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber.isEnabled = false
        edtNumber.inputType = InputType.TYPE_NULL

        currentNumber = ""
        calculationString = currentNumber
        txtCalculations.setText(calculationString)


    }

    fun buttonTapped(view: View){

        when (view.id) {

            R.id.btn0 -> numberisTapped(0)
            R.id.btn1 -> numberisTapped(1)
            R.id.btn2 -> numberisTapped(2)
            R.id.btn3 -> numberisTapped(3)
            R.id.btn4 -> numberisTapped(4)
            R.id.btn5 -> numberisTapped(5)
            R.id.btn6 -> numberisTapped(6)
            R.id.btn7 -> numberisTapped(7)
            R.id.btn8 -> numberisTapped(8)
            R.id.btn9 -> numberisTapped(9)

            R.id.btnDivide -> {
                operatorIsTapped(OPERATOR.DIVIDE)
                calculationString += " / "
            }

            R.id.btnMultiply -> {
                operatorIsTapped(OPERATOR.MULTIPLY)
                calculationString += " * "
            }
            R.id.btnPlus -> {
                operatorIsTapped(OPERATOR.PLUS)
                calculationString += " + "
            }
            R.id.btnSubstraction -> {
                operatorIsTapped(OPERATOR.SUBTRACT)
                calculationString += " - "
            }
            R.id.btnEqual -> {
                    operatorIsTapped(OPERATOR.EQUAL)

                }

            R.id.btnPercent -> {
                    implementPercent()
                    calculationString += " % "
                }

            R.id.btnClear -> {

                clar()
            }


        }
        txtCalculations.setText(calculationString)


    }

    private fun numberisTapped(tappedNumber: Int) {

        currentNumber += tappedNumber.toString()
        edtNumber.setText(currentNumber)
        calculationString = currentNumber



    }

    private fun operatorIsTapped(tappedOperator: OPERATOR){

        if(currentOperator != null){

            if(currentNumber != ""){

                stringNumberAtRight = currentNumber

                currentNumber = ""

                when(currentOperator){

                    OPERATOR.PLUS -> calculationResult = (stringNumberAtLeft)!!.toDouble() +
                        (stringNumberAtRight)!!.toDouble()

                    OPERATOR.SUBTRACT -> calculationResult = (stringNumberAtLeft)!!.toDouble() -
                            (stringNumberAtRight)!!.toDouble()

                    OPERATOR.MULTIPLY -> calculationResult = (stringNumberAtLeft)!!.toDouble() *
                            (stringNumberAtRight)!!.toDouble()

                    OPERATOR.DIVIDE -> calculationResult = (stringNumberAtLeft)!!.toDouble() /
                            (stringNumberAtRight)!!.toDouble()

                }

                stringNumberAtLeft = calculationResult.toString()
                edtNumber.setText(calculationResult.toString())
                calculationString = stringNumberAtLeft

            }


        } else{

            stringNumberAtLeft = currentNumber
            currentNumber = ""

        }
        currentOperator = tappedOperator


    }

    private fun implementPercent() {

        var percentValue = edtNumber.text.toString().toDouble() / 100

        currentNumber = percentValue.toString()
        edtNumber.setText(currentNumber)
    }

    private fun clar(){
        stringNumberAtLeft = ""
        stringNumberAtRight = ""
        calculationResult = 0.0
        currentNumber = ""
        currentOperator = null
        edtNumber.setText("0")
        calculationString = "0"
    }
}
