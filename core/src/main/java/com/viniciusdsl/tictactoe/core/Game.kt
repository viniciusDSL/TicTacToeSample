package com.viniciusdsl.tictactoe.core

class Game(private var gameMap: MutableList<MutableList<Int>> = emptyGame()) {

    var isFinished = false

    fun verifyGameMap(): Boolean {
            isFinished = when {
                verifyColumns() -> true
                verifyRows() -> true
                verifyDiagonals() -> true
                else -> false
            }
        return isFinished
    }

    private fun verifyRows(): Boolean {
        return when{
            gameMap[0][0] != 0 && gameMap[0][0] == gameMap[0][1] && gameMap[0][1] == gameMap[0][2] -> true
            gameMap[1][0] != 0 && gameMap[1][0] == gameMap[1][1] && gameMap[1][1] == gameMap[1][2] -> true
            gameMap[2][0] != 0 && gameMap[2][0] == gameMap[2][1] && gameMap[2][1] == gameMap[2][2] -> true
            else -> false
        }
    }

    private fun verifyColumns(): Boolean {
        return when{
            gameMap[0][0] != 0 && gameMap[0][0] == gameMap[1][0] && gameMap[1][0] == gameMap[2][0] -> true
            gameMap[0][1] != 0 && gameMap[0][1] == gameMap[1][1] && gameMap[1][1] == gameMap[2][1] -> true
            gameMap[0][2] != 0 && gameMap[0][2] == gameMap[1][2] && gameMap[1][2] == gameMap[2][2] -> true
            else -> false
        }
    }

    private fun verifyDiagonals(): Boolean {
        return when{
            gameMap[0][0] != 0 && gameMap[0][0] == gameMap[1][1] && gameMap[1][1] == gameMap[2][2] -> true
            gameMap[2][0] != 0 && gameMap[2][0] == gameMap[1][1] && gameMap[1][1] == gameMap[0][2] -> true
            else -> false
        }
    }



    fun markPosition(position: TicTacToePosition, player: Player): Boolean{
        when (position) {
            TicTacToePosition.ONE -> {
                if (gameMap[0][0] != 0 ) return false
                gameMap[0][0] = player.playerNumber
            }
            TicTacToePosition.TWO -> {
                if(gameMap[0][1] != 0 ) return false
                gameMap[0][1] = player.playerNumber
            }
            TicTacToePosition.THREE -> {
                if(gameMap[0][2] != 0 ) return false
                gameMap[0][2] = player.playerNumber
            }
            TicTacToePosition.FOUR -> {
                if(gameMap[1][0] != 0 ) return false
                gameMap[1][0] = player.playerNumber
            }
            TicTacToePosition.FIVE -> {
                if(gameMap[1][1] != 0 ) return false
                gameMap[1][1] = player.playerNumber
            }
            TicTacToePosition.SIX -> {
                if(gameMap[1][2] != 0 ) return false
                gameMap[1][2] = player.playerNumber
            }
            TicTacToePosition.SEVEN -> {
                if(gameMap[2][0] != 0 ) return false
                gameMap[2][0] = player.playerNumber
            }
            TicTacToePosition.EIGHT -> {
                if(gameMap[2][1] != 0 ) return false
                gameMap[2][1] = player.playerNumber
            }
            TicTacToePosition.NINE -> {
                if(gameMap[2][2] != 0 ) return false
                gameMap[2][2] = player.playerNumber
            }
        }
        return true
    }

    fun resetGame() {
        gameMap = emptyGame()
        isFinished = false
    }

    fun verifyDraw(): Boolean {
        gameMap.forEach {
            if (it.contains(0)) {
                isFinished = false
                return isFinished
            }
        }
        isFinished = true
        return isFinished
    }
}

private fun emptyGame() = mutableListOf(
    mutableListOf(0,0,0),
    mutableListOf(0,0,0),
    mutableListOf(0,0,0))

