package com.viniciusdsl.tictactoe.test

import com.viniciusdsl.tictactoe.core.model.Game
import org.junit.Assert.assertEquals
import org.junit.Test

class GameTest {

    @Test
    fun testWinGames(){
        var game = Game(
            mutableListOf(
                mutableListOf(1, 0, 0),
                mutableListOf(0, 1, 0),
                mutableListOf(0, 0, 1)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(2, 1, 0),
                mutableListOf(1, 0, 0)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 1, 1),
                mutableListOf(2, 2, 0),
                mutableListOf(0, 0, 0)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(2, 2, 2),
                mutableListOf(1, 0, 0)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 0, 1),
                mutableListOf(1, 1, 0),
                mutableListOf(2, 2, 2)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(1, 2, 0),
                mutableListOf(1, 0, 0)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(0, 2, 0),
                mutableListOf(1, 2, 0)
            )
        )
        assertEquals(true, game.verifyGameMap())

        game = Game(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(2, 0, 1),
                mutableListOf(1, 0, 1)
            )
        )
        assertEquals(true, game.verifyGameMap())
    }

    @Test
    fun testDraw() {
        var game = Game(
            mutableListOf(
                mutableListOf(1, 0, 0),
                mutableListOf(0, 1, 0),
                mutableListOf(0, 0, 1)
            )
        )
        assertEquals(false, game.verifyDraw())

        game = Game(
            mutableListOf(
                mutableListOf(1, 1, 2),
                mutableListOf(1, 2, 2),
                mutableListOf(2, 1, 1)
            )
        )
        assertEquals(true, game.verifyDraw())

        game = Game(
            mutableListOf(
                mutableListOf(1, 1, 2),
                mutableListOf(1, 2, 2),
                mutableListOf(2, 1, 0)
            )
        )
        assertEquals(false, game.verifyDraw())
    }
}