package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


/*
*
* Nahomi Machuca
* Septimo A
*
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)/*para buscar por id*/
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)/*cantidad de caras del dado*/
        val diceRoll = dice.roll()
        //para encontrar la imagen
        val diceImage: ImageView = findViewById(R.id.imageView)
        /*Se indica el Id de cada imagen*/
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        /*Actualiza la imagen segun el id*/
        diceImage.setImageResource(drawableResource)
        //Actualiza la descripcion del contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}
/*Creacion clase dice*/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}