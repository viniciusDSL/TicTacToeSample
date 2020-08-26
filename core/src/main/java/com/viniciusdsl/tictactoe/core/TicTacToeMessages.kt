package com.viniciusdsl.tictactoe.core

abstract class TicTacToeMessages {
    abstract fun getErrorMessage(): String
    abstract fun getGameFinishedMessage(winnerPlayer: Player): String
    abstract fun getGameFinishedDrawMessage(): String
    abstract fun getGameFinishedMessage(): String
}