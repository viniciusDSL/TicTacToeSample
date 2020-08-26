package com.viniciusdsl.tictactoe.without_engine

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.viniciusdsl.tictactoe.R
import com.viniciusdsl.tictactoe.TicTacToeMessagesImpl
import com.viniciusdsl.tictactoe.core.GamePresenter
import com.viniciusdsl.tictactoe.core.util.TicTacToePosition
import com.viniciusdsl.tictactoe.core.TicTacToeView
import kotlinx.android.synthetic.main.activity_native.*
import kotlinx.android.synthetic.main.row_layout.view.*

class NativeUIActivity : AppCompatActivity(), TicTacToeView {

    private val presenter = GamePresenter( TicTacToeMessagesImpl(this), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        firstRow.textView_first_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.ONE)
        }
        firstRow.textView_second_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.TWO)
        }
        firstRow.textView_third_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.THREE)
        }

        secondRow.textView_first_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.FOUR)
        }
        secondRow.textView_second_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.FIVE)
        }
        secondRow.textView_third_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.SIX)
        }

        thirdRow.textView_first_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.SEVEN)
        }
        thirdRow.textView_second_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.EIGHT)
        }
        thirdRow.textView_third_column.setOnClickListener {
            presenter.markAtPosition(TicTacToePosition.NINE)
        }
        button_reset.setOnClickListener {
            presenter.resetGame()
            firstRow.textView_first_column.text =  "----"
            firstRow.textView_second_column.text =  "----"
            firstRow.textView_third_column.text =  "----"
            secondRow.textView_first_column.text =  "----"
            secondRow.textView_second_column.text =  "----"
            secondRow.textView_third_column.text =  "----"
            thirdRow.textView_first_column.text =  "----"
            thirdRow.textView_second_column.text =  "----"
            thirdRow.textView_third_column.text =  "----"
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun updatedAtPosition(ticTacToePosition: TicTacToePosition, character: Char) {
        when (ticTacToePosition) {
            TicTacToePosition.ONE -> {
                firstRow.textView_first_column.text =  character.toString()
            }
            TicTacToePosition.TWO -> {
                firstRow.textView_second_column.text =  character.toString()
            }
            TicTacToePosition.THREE -> {
                firstRow.textView_third_column.text =  character.toString()
            }
            TicTacToePosition.FOUR -> {
                secondRow.textView_first_column.text =  character.toString()
            }
            TicTacToePosition.FIVE -> {
                secondRow.textView_second_column.text =  character.toString()
            }
            TicTacToePosition.SIX -> {
                secondRow.textView_third_column.text =  character.toString()
            }
            TicTacToePosition.SEVEN -> {
                thirdRow.textView_first_column.text =  character.toString()
            }
            TicTacToePosition.EIGHT -> {
                thirdRow.textView_second_column.text =  character.toString()
            }
            TicTacToePosition.NINE -> {
                thirdRow.textView_third_column.text =  character.toString()
            }
        }
    }
}