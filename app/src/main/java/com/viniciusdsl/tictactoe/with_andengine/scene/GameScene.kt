package com.viniciusdsl.tictactoe.with_andengine.scene

import com.viniciusdsl.tictactoe.with_andengine.sprite.AnimalSprite
import org.andengine.entity.scene.Scene
import org.andengine.entity.scene.background.Background
import org.andengine.util.adt.color.Color

class GameScene : Scene() {

     init {
         background = Background(Color.WHITE)
         attachChild(AnimalSprite.createInstance(100f,260f,1))
         attachChild(AnimalSprite.createInstance(240f,260f,1))
         attachChild(AnimalSprite.createInstance(380f,260f,1))
         attachChild(AnimalSprite.createInstance(100f,400f,2))
         attachChild(AnimalSprite.createInstance(240f,400f,2))
         attachChild(AnimalSprite.createInstance(380f,400f,2))
         attachChild(AnimalSprite.createInstance(100f,540f,1))
         attachChild(AnimalSprite.createInstance(240f,540f,1))
         attachChild(AnimalSprite.createInstance(380f,540f,1))
     }

}