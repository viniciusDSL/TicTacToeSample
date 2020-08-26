package com.viniciusdsl.tictactoe.with_andengine.sprite

import com.viniciusdsl.tictactoe.with_andengine.ResourceManager
import org.andengine.entity.sprite.Sprite
import org.andengine.opengl.texture.region.ITextureRegion

class AnimalSprite private constructor(posX: Float, posY: Float, textureRegion: ITextureRegion) : Sprite(posX, posY,100f,100f,textureRegion,
ResourceManager.getVertexBuffer()) {

    companion object{
        fun createInstance(posX: Float, posY: Float, animalType: Int ) : AnimalSprite =
            when(animalType) {
                1 -> AnimalSprite(posX, posY, ResourceManager.PARROT_TEXTURE)
                else -> AnimalSprite(posX, posY, ResourceManager.PENGUIN_TEXTURE)
            }
    }


}