package com.viniciusdsl.tictactoe.with_andengine.scene

import com.viniciusdsl.tictactoe.TicTacToeMessagesImpl
import com.viniciusdsl.tictactoe.core.GamePresenter
import com.viniciusdsl.tictactoe.core.util.TicTacToePosition
import com.viniciusdsl.tictactoe.core.TicTacToeView
import com.viniciusdsl.tictactoe.with_andengine.ResourceManager
import com.viniciusdsl.tictactoe.with_andengine.sprite.AnimalSprite
import org.andengine.entity.IEntity
import org.andengine.entity.modifier.AlphaModifier
import org.andengine.entity.modifier.DelayModifier
import org.andengine.entity.modifier.IEntityModifier
import org.andengine.entity.scene.Scene
import org.andengine.entity.scene.background.Background
import org.andengine.entity.sprite.ButtonSprite
import org.andengine.entity.text.Text
import org.andengine.util.adt.color.Color
import org.andengine.util.modifier.IModifier

class GameScene : Scene(), TicTacToeView, AnimalSprite.Callback {

    private val presenter: GamePresenter =
        GamePresenter(TicTacToeMessagesImpl(ResourceManager.getApplicationContext()), this)

    private val animalSprites = arrayOfNulls<AnimalSprite>(9)

    private val textMessage = Text(240f,700f,ResourceManager.FONT,"0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM",
        "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".length, ResourceManager.getVertexBuffer())

    val buttonSprite = ButtonSprite(
        240f,
        120f,
        ResourceManager.RESET_BUTTON_TEXTURE,
        ResourceManager.getVertexBuffer()
    ).apply {
        setScale(0.7f)
    }

    init {
        background = Background(Color.WHITE)
        animalSprites[6] = AnimalSprite(100f, 260f, TicTacToePosition.SEVEN, this)
        animalSprites[7] = AnimalSprite(240f, 260f, TicTacToePosition.EIGHT, this)
        animalSprites[8] = AnimalSprite(380f, 260f, TicTacToePosition.NINE, this)
        animalSprites[3] = AnimalSprite(100f, 400f, TicTacToePosition.FOUR, this)
        animalSprites[4] = AnimalSprite(240f, 400f, TicTacToePosition.FIVE, this)
        animalSprites[5] = AnimalSprite(380f, 400f, TicTacToePosition.SIX, this)
        animalSprites[0] = AnimalSprite(100f, 540f, TicTacToePosition.ONE, this)
        animalSprites[1] = AnimalSprite(240f, 540f, TicTacToePosition.TWO, this)
        animalSprites[2] = AnimalSprite(380f, 540f, TicTacToePosition.THREE, this)

        animalSprites.forEach {
            attachChild(it)
            registerTouchArea(it)
        }
        isTouchAreaBindingOnActionDownEnabled = true
        attachChild(buttonSprite)
        registerTouchArea(buttonSprite)
        buttonSprite.setOnClickListener { _, _, _ ->
            ResourceManager.getEngine().scene = GameScene()
        }
        textMessage.text = ""
        attachChild(textMessage)
    }

    override fun showMessage(message: String) {
        textMessage.text = ""
        textMessage.alpha = 1f
        textMessage.clearEntityModifiers()
        textMessage.registerEntityModifier(DelayModifier(3f,object :IEntityModifier.IEntityModifierListener{
            override fun onModifierStarted(p0: IModifier<IEntity>?, p1: IEntity?) {
                textMessage.text = message
            }

            override fun onModifierFinished(p0: IModifier<IEntity>?, p1: IEntity?) {
                textMessage.registerEntityModifier(AlphaModifier(1.5f,1f,0f,
                    object :IEntityModifier.IEntityModifierListener{
                        override fun onModifierStarted(p0: IModifier<IEntity>?, p1: IEntity?) {

                        }

                        override fun onModifierFinished(p0: IModifier<IEntity>?, p1: IEntity?) {
                            textMessage.text = ""
                        }

                    }))
            }

        }))
    }

    override fun updatedAtPosition(ticTacToePosition: TicTacToePosition, character: Char) {
        attachChild(when (ticTacToePosition) {
            TicTacToePosition.ONE -> {
                animalSprites[0]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.TWO -> {
                animalSprites[1]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.THREE -> {
                animalSprites[2]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.FOUR -> {
                animalSprites[3]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.FIVE -> {
                animalSprites[4]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.SIX -> {
                animalSprites[5]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.SEVEN -> {
                animalSprites[6]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.EIGHT -> {
                animalSprites[7]?.showAnimal(if (character == 'X') 1 else 2)
            }
            TicTacToePosition.NINE -> {
                animalSprites[8]?.showAnimal(if (character == 'X') 1 else 2)
            }
        })
    }

    override fun onPositionSelected(ticTacToePosition: TicTacToePosition) {
        presenter.markAtPosition(ticTacToePosition)
    }

}