package com.viniciusdsl.tictactoe.with_andengine.sprite

import com.viniciusdsl.tictactoe.core.util.TicTacToePosition
import com.viniciusdsl.tictactoe.with_andengine.ResourceManager
import org.andengine.entity.sprite.Sprite
import org.andengine.input.touch.TouchEvent

class AnimalSprite(
    posX: Float,
    posY: Float,
    val ticTacToePosition: TicTacToePosition,
    val callback: Callback
) : Sprite(
    posX, posY, 100f, 100f, ResourceManager.SQUARE_TEXTURE,
    ResourceManager.getVertexBuffer()
) {

    private lateinit var animal: Sprite
    private val size = 100f

    fun showAnimal(animalType: Int): Sprite {
        when (animalType) {
            1 -> animal = Sprite(
                x,
                y,
                size,
                size,
                ResourceManager.PARROT_TEXTURE,
                ResourceManager.getVertexBuffer()
            )
            2 -> animal = Sprite(
                x,
                y,
                size,
                size,
                ResourceManager.PENGUIN_TEXTURE,
                ResourceManager.getVertexBuffer()
            )
        }
        alpha = 0f
        return animal
    }

    override fun onAreaTouched(
        pSceneTouchEvent: TouchEvent,
        pTouchAreaLocalX: Float,
        pTouchAreaLocalY: Float
    ): Boolean {
        return if (pSceneTouchEvent.isActionDown) {
            callback.onPositionSelected(ticTacToePosition)
            true
        } else {
            super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY)
        }
    }

    interface Callback {
        fun onPositionSelected(ticTacToePosition: TicTacToePosition)
    }
}