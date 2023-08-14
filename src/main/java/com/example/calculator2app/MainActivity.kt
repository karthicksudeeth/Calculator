package com.example.calculator2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClick()
        val clear=findViewById<Button>(R.id.btnClear)
        clear.setOnClickListener {
            str=""
            val show=findViewById<TextView>(R.id.tvNum);
            show.text=str
            calculate()
        }

        val bs=findViewById<Button>(R.id.btnBs)
        bs.setOnClickListener {
            str=str.dropLast(1)
            val show=findViewById<TextView>(R.id.tvNum);
            show.text=str
            calculate()
        }

        val equal=findViewById<Button>(R.id.btnEqual)
        equal.setOnClickListener {
            val result=findViewById<TextView>(R.id.tvResult)
            str=result.text.toString();
            result.text=""
            val show=findViewById<TextView>(R.id.tvNum);
            show.text=str
        }



    }

    private var str="";

    private fun setOnClick(){
        val btn0=findViewById<Button>(R.id.btn0)
        val btn1=findViewById<Button>(R.id.btn1)
        val btn2=findViewById<Button>(R.id.btn2)
        val btn3=findViewById<Button>(R.id.btn3)
        val btn4=findViewById<Button>(R.id.btn4)
        val btn5=findViewById<Button>(R.id.btn5)
        val btn6=findViewById<Button>(R.id.btn6)
        val btn7=findViewById<Button>(R.id.btn7)
        val btn8=findViewById<Button>(R.id.btn8)
        val btn9=findViewById<Button>(R.id.btn9)
        val btnDot=findViewById<Button>(R.id.btnDot)
        val btnPlus=findViewById<Button>(R.id.btnPlus)
        val btnMinus=findViewById<Button>(R.id.btnMinus)
        val btnMultiply=findViewById<Button>(R.id.btnMultiply)
        val btnDivide=findViewById<Button>(R.id.btnDivide)
        val btnMod=findViewById<Button>(R.id.btnMod)

        val numberButtons= listOf<Button>(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnPlus,btnMinus,btnDivide,btnMultiply,btnMod)

        for(button in numberButtons){
            button.setOnClickListener {
                str+=button.text.toString()
                val show=findViewById<TextView>(R.id.tvNum);
                show.text=str
                calculate()


            }
        }


    }
    private fun calculate(){
        var operator=' '
        var temp1="0"
        var temp2="0"
        var calulatedvalue=0.0;
        for(i in str){
            if(i=='+' || i=='-' || i=='%' || i=='*' || i=='/'){
                val tem1=temp1.toDouble()
                val tem2=temp2.toDouble()
                calulatedvalue=when(operator) {
                    '+' -> tem2 + tem1
                    '-' -> tem2-tem1
                    '*' -> tem2*tem1
                    '/' -> tem2/tem1
                    '%' -> tem2%tem1
                    else->tem1

                }
                operator=i
                temp2=calulatedvalue.toString();
                temp1="0"
            }
            else{
                temp1+=i;
            }
        }
        val tem1=temp1.toDouble()
        val tem2=temp2.toDouble()

        calulatedvalue=when(operator) {
            '+' -> tem2 + tem1
            '-' -> tem2-tem1
            '*' -> tem2*tem1
            '/' -> tem2/tem1
            '%' -> tem2%tem1
            else->tem1

        }

        val result=findViewById<TextView>(R.id.tvResult)
        result.text=calulatedvalue.toString()
    }
}