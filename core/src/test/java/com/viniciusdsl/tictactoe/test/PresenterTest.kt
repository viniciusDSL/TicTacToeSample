package com.viniciusdsl.tictactoe.test

import com.viniciusdsl.tictactoe.core.*
import com.viniciusdsl.tictactoe.test.util.TestTicTacToeMessages
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PresenterTest {

    @Mock
    lateinit var gameView: TicTacToeView

    lateinit var presenter: TicTacToePresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = GamePresenter(TestTicTacToeMessages(), gameView)
    }

    @Test
    fun testMarkPosition() {
        presenter.markAtPosition(TicTacToePosition.ONE)
        verify(gameView, times(1)).updatedAtPosition(TicTacToePosition.ONE, 'X')
        presenter.markAtPosition(TicTacToePosition.ONE)
        verify(gameView, times(1)).showMessage("error")
        presenter.markAtPosition(TicTacToePosition.FOUR)
        verify(gameView, times(1)).updatedAtPosition(TicTacToePosition.FOUR, 'O')
        presenter.markAtPosition(TicTacToePosition.TWO)
        verify(gameView, times(1)).updatedAtPosition(TicTacToePosition.TWO, 'X')
        presenter.markAtPosition(TicTacToePosition.FIVE)
        verify(gameView, times(1)).updatedAtPosition(TicTacToePosition.FIVE, 'O')
        presenter.markAtPosition(TicTacToePosition.THREE)
        verify(gameView, times(1)).updatedAtPosition(TicTacToePosition.THREE, 'X')
        verify(gameView, times(1)).showMessage("Gana el jugador 1")
        presenter.markAtPosition(TicTacToePosition.THREE)
        verify(gameView, times(1)).showMessage("juego terminado")
    }

}