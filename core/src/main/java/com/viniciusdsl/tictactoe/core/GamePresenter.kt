package com.viniciusdsl.tictactoe.core

import com.viniciusdsl.tictactoe.core.model.Game
import com.viniciusdsl.tictactoe.core.model.Player
import com.viniciusdsl.tictactoe.core.util.TicTacToeMessages
import com.viniciusdsl.tictactoe.core.util.TicTacToePosition

class GamePresenter(private val gameMessages: TicTacToeMessages, gameView: TicTacToeView) : TicTacToePresenter(gameView){
    private val player1 = Player(1)
    private val player2 = Player(2)
    private val game = Game()
    private var currentPlayer = 1

    override fun markAtPosition(ticTacToePosition: TicTacToePosition) {
        if (game.isFinished) {
            gameView.showMessage(gameMessages.getGameFinishedMessage())
        } else {
            if (game.markPosition(ticTacToePosition, getCurrentPlayer())) {
                gameView.updatedAtPosition(ticTacToePosition, if (currentPlayer == 1) {'X'} else {'O'})
                if (game.verifyGameMap()) {
                    gameView.showMessage(
                        gameMessages.getGameFinishedMessage(
                            if (currentPlayer == 1) player1 else player2
                        )
                    )
                } else if (game.verifyDraw()) {
                    gameView.showMessage(gameMessages.getGameFinishedDrawMessage())
                }
                currentPlayer = if (currentPlayer == 1) {2} else {1}
            } else {
                gameView.showMessage(gameMessages.getErrorMessage())
            }
        }
    }

    override fun resetGame() {
        currentPlayer = 1
        game.resetGame()
    }

    private fun getCurrentPlayer() = if (currentPlayer == 1) { player1 } else {player2}
}