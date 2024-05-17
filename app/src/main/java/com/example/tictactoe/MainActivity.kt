package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var player = "p1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            box1.setOnClickListener { onButtonClick(box1) }
            box2.setOnClickListener { onButtonClick(box2) }
            box3.setOnClickListener { onButtonClick(box3) }
            box4.setOnClickListener { onButtonClick(box4) }
            box5.setOnClickListener { onButtonClick(box5) }
            box6.setOnClickListener { onButtonClick(box6) }
            box7.setOnClickListener { onButtonClick(box7) }
            box8.setOnClickListener { onButtonClick(box8) }
            box9.setOnClickListener { onButtonClick(box9) }

            resetButton.setOnClickListener { resetGame() }
        }
    }

    private fun resetGame() {
        player = "p1"

        binding.apply {
            box1.background = resources.getDrawable(R.drawable.square)
            box2.background = resources.getDrawable(R.drawable.square)
            box3.background = resources.getDrawable(R.drawable.square)
            box4.background = resources.getDrawable(R.drawable.square)
            box5.background = resources.getDrawable(R.drawable.square)
            box6.background = resources.getDrawable(R.drawable.square)
            box7.background = resources.getDrawable(R.drawable.square)
            box8.background = resources.getDrawable(R.drawable.square)
            box9.background = resources.getDrawable(R.drawable.square)

            box1.text = ""
            box2.text = ""
            box3.text = ""
            box4.text = ""
            box5.text = ""
            box6.text = ""
            box7.text = ""
            box8.text = ""
            box9.text = ""

            box1.isClickable = true
            box2.isClickable = true
            box3.isClickable = true
            box4.isClickable = true
            box5.isClickable = true
            box6.isClickable = true
            box7.isClickable = true
            box8.isClickable = true
            box9.isClickable = true

            tvResult.text = ""
        }
    }

    private fun onButtonClick(button: Button) {
        if (button.text == ""){
            if (player == "p1"){
                button.background = resources.getDrawable(R.drawable.x)
                button.text = "x"
                button.isClickable = false

            } else {
                button.background = resources.getDrawable(R.drawable.o)
                button.text = "o"
                button.isClickable = false
                player = "p1"
            }
        }

        win()
    }

    private fun win() {
        binding.apply {
            if ((box1.text == "x" && box2.text == "x" && box3.text == "x") ||
                (box4.text == "x" && box5.text == "x" && box6.text == "x") ||
                (box7.text == "x" && box8.text == "x" && box9.text == "x") ||
                (box1.text == "x" && box4.text == "x" && box7.text == "x") ||
                (box2.text == "x" && box5.text == "x" && box8.text == "x") ||
                (box3.text == "x" && box6.text == "x" && box9.text == "x") ||
                (box1.text == "x" && box5.text == "x" && box9.text == "x") ||
                (box3.text == "x" && box5.text == "x" && box7.text == "x")) {
                tvResult.text = "X won the game"
                Toast.makeText(this@MainActivity, "X won the game", Toast.LENGTH_SHORT).show()
                disableButtons()
            } else if ((box1.text == "o" && box2.text == "o" && box3.text == "o") ||
                (box4.text == "o" && box5.text == "o" && box6.text == "o") ||
                (box7.text == "o" && box8.text == "o" && box9.text == "o") ||
                (box1.text == "o" && box4.text == "o" && box7.text == "o") ||
                (box2.text == "o" && box5.text == "o" && box8.text == "o") ||
                (box3.text == "o" && box6.text == "o" && box9.text == "o") ||
                (box1.text == "o" && box5.text == "o" && box9.text == "o") ||
                (box3.text == "o" && box5.text == "o" && box7.text == "o")
                ) {
                tvResult.text = "O won the game"
                Toast.makeText(this@MainActivity, "O won the game", Toast.LENGTH_SHORT).show()
                disableButtons()
            } else if (box1.text != "" && box2.text != "" && box3.text != "" &&
                        box4.text != "" && box5.text != "" && box6.text != "" &&
                        box7.text != "" && box8.text != "" && box9.text != ""
                    ) {
                tvResult.text = "Match Draw"
                Toast.makeText(this@MainActivity, "It's a Tie... Play again...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun disableButtons() {
        binding.apply {
            box1.isClickable = false
            box2.isClickable = false
            box3.isClickable = false
            box4.isClickable = false
            box5.isClickable = false
            box6.isClickable = false
            box7.isClickable = false
            box8.isClickable = false
            box9.isClickable = false
        }
    }
}