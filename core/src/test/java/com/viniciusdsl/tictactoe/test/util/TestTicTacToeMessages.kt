package com.viniciusdsl.tictactoe.test.util

import com.viniciusdsl.tictactoe.core.model.Player
import com.viniciusdsl.tictactoe.core.util.TicTacToeMessages

class TestTicTacToeMessages : TicTacToeMessages() {

    override fun getErrorMessage(): String = "error"

    override fun getGameFinishedMessage(winnerPlayer: Player): String = "Gana el jugador ${winnerPlayer.playerNumber}"

    override fun getGameFinishedMessage(): String  = "juego terminado"

    override fun getGameFinishedDrawMessage(): String = "empate"
}