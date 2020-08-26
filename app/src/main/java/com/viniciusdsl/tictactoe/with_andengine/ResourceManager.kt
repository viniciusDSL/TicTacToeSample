package com.viniciusdsl.tictactoe.with_andengine

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import org.andengine.engine.Engine
import org.andengine.opengl.font.Font
import org.andengine.opengl.font.FontFactory
import org.andengine.opengl.texture.TextureOptions
import org.andengine.opengl.texture.bitmap.BitmapTexture
import org.andengine.opengl.texture.region.*
import org.andengine.opengl.vbo.VertexBufferObjectManager
import org.andengine.util.adt.io.`in`.IInputStreamOpener
import java.io.IOException

object ResourceManager {

    private const val ASSETS_ERROR_TAG = "TicTacToe - assets: "

    lateinit var PENGUIN_TEXTURE: ITextureRegion
    lateinit var PARROT_TEXTURE: ITextureRegion
    lateinit var SQUARE_TEXTURE: ITextureRegion
    lateinit var RESET_BUTTON_TEXTURE: ITiledTextureRegion
    lateinit var FONT: Font
    private lateinit var engine: Engine
    private lateinit var context: Context

    private fun getTiledTextureFromAsset(
        path: String,
        rows: Int,
        columns: Int,
        engine: Engine,
        context: Context
    ): TiledTextureRegion? {
        try {
            val texture = BitmapTexture(engine.textureManager, IInputStreamOpener {
                context.assets.open("gfx/$path") // path of the image
            }, TextureOptions.BILINEAR)
            texture.load()
            return TextureRegionFactory.extractTiledFromTexture(texture, rows, columns)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e(ASSETS_ERROR_TAG, e.toString())
        }
        return null
    }

    private fun getTextureFromAsset(
        path: String, engine: Engine,
        context: Context
    ): TextureRegion? {
        try {
            val texture = BitmapTexture(engine.textureManager, IInputStreamOpener {
                context.getAssets().open("gfx/$path") // path of the image
            }, TextureOptions.BILINEAR)
            texture.load()
            return TextureRegionFactory.extractFromTexture(texture)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e(ASSETS_ERROR_TAG, e.toString())
        }
        return null
    }

    private fun loadFont(
        fontName: String, fontSize: Int, engine: Engine, context: Context
    ): Font? {
        FontFactory.setAssetBasePath("font/")
        val fontRes: Font = FontFactory.createFromAsset(
            engine.fontManager,
            engine.textureManager,
            512,
            512,
            TextureOptions.BILINEAR_PREMULTIPLYALPHA,
            context.assets,
            fontName,
            fontSize.toFloat(),
            true,
            Color.BLACK
        )
        fontRes.load()
        return fontRes
    }

    fun loadBasicResources(engine: Engine, activity: Activity) {
        context = activity.applicationContext
        this.engine = engine

        getTextureFromAsset("square.png", engine, activity)?.let {
            SQUARE_TEXTURE = it
        }

        getTextureFromAsset("parrot.png", engine, activity)?.let {
            PARROT_TEXTURE = it
        }

        getTextureFromAsset("penguin.png", engine, activity)?.let {
            PENGUIN_TEXTURE = it
        }

        getTiledTextureFromAsset("reset_button.png", 3, 1, engine, activity)?.let {
            RESET_BUTTON_TEXTURE = it
        }

        loadFont("sans.TTF", 20, engine, activity)?.let {
            FONT = it
        }
    }

    fun getVertexBuffer(): VertexBufferObjectManager = engine.vertexBufferObjectManager

    fun getApplicationContext(): Context = context

    fun getEngine(): Engine = engine
}