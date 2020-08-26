package com.viniciusdsl.tictactoe.core.util

import com.viniciusdsl.tictactoe.core.model.Player

abstract class TicTacToeMessages {
    abstract fun getErrorMessage(): String
    abstract fun getGameFinishedMessage(winnerPlayer: Player): String
    abstract fun getGameFinishedDrawMessage(): String
    abstract fun getGameFinishedMessage(): String
}