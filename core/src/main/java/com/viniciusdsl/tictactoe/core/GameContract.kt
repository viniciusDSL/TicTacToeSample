package com.viniciusdsl.tictactoe.core

abstract class TicTacToePresenter(val gameView: TicTacToeView) {
    abstract fun markAtPosition(ticTacToePosition: TicTacToePosition)
    abstract fun resetGame()
}

interface TicTacToeView {
    fun showMessage(message: String)
    fun updatedAtPosition(ticTacToePosition: TicTacToePosition, character: Char)
}