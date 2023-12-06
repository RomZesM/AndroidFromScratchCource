package com.example.homework_sandbox_week01

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.homework_sandbox_week01.utils.SealedClassTesting

class MainActivity : AppCompatActivity() {

    var adress = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Spis_Castle_116.jpg/2560px-Spis_Castle_116.jpg"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sandboxInit();
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sandboxInit() {
        val resultView = findViewById<TextView>(R.id.result)
        buttonPotatoInit(resultView)
        buttonBananaInit(resultView)
        buttonAppleInit(resultView)
        nextButtonInit();
        //
       // var imageView = findViewById<ImageView>(R.id.image_view);
       // imageView.getImageFromURL(this, adress);
    }

    private fun nextButtonInit() {
        val nextButtonn = findViewById<Button>(R.id.next_button)
        nextButtonn.setOnClickListener({
            var intent = Intent(this, ExtensionTesting::class.java);
            startActivity(intent);
        })
    }

    private fun buttonAppleInit(resView: TextView?) {
        val button = findViewById<TextView>(R.id.fr_apple_button)
        button.setOnClickListener({
            Toast.makeText(this, "PotatoButton was clicked", Toast.LENGTH_SHORT).show()
            var apple = SealedClassTesting.Apple (70, "Red", "Jonagold")
            resView?.setText(useMeal(apple));

            //test get method
            println(apple.varietyInfo)
        })


    }
    
    private fun buttonPotatoInit(resView : TextView) {
        val button = findViewById<TextView>(R.id.fr_potato_button)
        button.setOnClickListener({
            Toast.makeText(this, "PotatoButton was clicked", Toast.LENGTH_SHORT).show()
            //create potato with negative weight
            val potatoTest = SealedClassTesting.Potato(-1, "Green", "BlueEyes")
            println(potatoTest.weight);
            potatoTest.weight = -2;
            println(potatoTest.weight);
            val potato = SealedClassTesting.Potato(100, "Brown", "BlueEyes")
            println(potato.weight)
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