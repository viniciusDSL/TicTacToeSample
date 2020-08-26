package com.viniciusdsl.tictactoe

import android.content.Context
import com.viniciusdsl.tictactoe.core.model.Player
import com.viniciusdsl.tictactoe.core.util.TicTacToeMessages

class TicTacToeMessagesImpl (val context: Context) : TicTacToeMessages() {

    override fun getErrorMessage(): String = context.getString(R.string.error_message)

    override fun getGameFinishedMessage(winnerPlayer: Player): String =
        context.getString(R.string.winner_message, winnerPlayer.playerNumber)

    override fun getGameFinishedMessage(): String = context.getString(R.string.game_finished)

    override fun getGameFinishedDrawMessage(): String = context.getString(R.string.draw_message)

}