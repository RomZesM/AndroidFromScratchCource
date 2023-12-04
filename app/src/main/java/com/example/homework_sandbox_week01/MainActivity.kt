package com.example.homework_sandbox_week01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sandboxInit();
    }

    private fun sandboxInit() {
        val resultView = findViewById<TextView>(R.id.result)
        buttonPotatoInit(resultView)
        buttonBananaInit(resultView)
        buttonAppleInit(resultView)
    }

    private fun buttonAppleInit(resView: TextView?) {
        val button = findViewById<TextView>(R.id.fr_apple_button)
        button.setOnClickListener({
            Toast.makeText(this, "PotatoButton was clicked", Toast.LENGTH_SHORT).show()
            var apple = SealedClassTesting.Apple (70, "Red", "Jonagold")
            resView?.setText(useMeal(apple));
        })


    }


    private fun buttonPotatoInit(resView : TextView) {
        val button = findViewById<TextView>(R.id.fr_potato_button)
        button.setOnClickListener({
            Toast.makeText(this, "PotatoButton was clicked", Toast.LENGTH_SHORT).show()
            val potato = SealedClassTesting.Potato(100, "Brown", "BlueEyes")
            resView.setText(useMeal(potato));
        })
    }

    private fun buttonBananaInit(resView : TextView) {
        val button = findViewById<TextView>(R.id.fr_banana_button);
        button.setOnClickListener({
            Toast.makeText(this, "Banana button was clicked", Toast.LENGTH_SHORT).show()
            val banan = SealedClassTesting.Banan (150, "Yellow")
            resView.setText(useMeal(banan))
        })

    }

    //function accept any of subclasses of the sealed class
    private fun useMeal(meal: SealedClassTesting): String {
        return when(meal){
            is SealedClassTesting.Apple -> {
                var algorytm = ""
                if(testMeal(meal)){
                    algorytm = "1) WashIt(), 2) EatIt!"
                } else algorytm = "ThrowItAway()"
                return algorytm;
            }
            is SealedClassTesting.Potato -> {
                var algorytm = ""
                algorytm = if(testMeal(meal)){
                    "1) WashIt(), 2) PeelIt! 3) BoilIt() 4) EatIt()"
                } else "ThrowItAway()"
                return algorytm;
            }
            is SealedClassTesting.Banan -> {
                var algorytm = ""
                if(testMeal(meal)){
                    algorytm = "1) PeelIt! 2) EatIt()"
                } else algorytm = "ThrowItAway()"
                return algorytm;
            }
        }
    }


    //using kotlin-When with sealed Class
    private fun testMeal(meal: SealedClassTesting): Boolean {
       var retVal = true;
        when(meal){
            is SealedClassTesting.Apple -> {
               if (meal.color.uppercase() == "BROWN")
                    retVal = false
                        return retVal}
            is SealedClassTesting.Potato -> {
               if (meal.color.uppercase() != "BROWN")
                   retVal = false;
                return retVal}
            is SealedClassTesting.Banan -> {
              if  (meal.color.uppercase() != "YELLOW")
                    retVal = false
                return retVal}

            else -> return retVal;

        }
    }
}