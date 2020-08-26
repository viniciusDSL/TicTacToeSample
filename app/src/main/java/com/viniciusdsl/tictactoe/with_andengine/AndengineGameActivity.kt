package com.viniciusdsl.tictactoe.with_andengine

import com.viniciusdsl.tictactoe.with_andengine.scene.GameScene
import org.andengine.engine.camera.SmoothCamera
import org.andengine.engine.camera.ZoomCamera
import org.andengine.engine.options.EngineOptions
import org.andengine.engine.options.ScreenOrientation
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy
import org.andengine.entity.scene.Scene
import org.andengine.ui.IGameInterface
import org.andengine.ui.activity.BaseGameActivity

class AndengineGameActivity : BaseGameActivity() {

    companion object {
        const val CAMERA_WIDTH = 480f
        const val CAMERA_HEIGHT = 800f
        lateinit var camera: ZoomCamera
    }

    override fun onCreateEngineOptions(): EngineOptions {
        camera =
            SmoothCamera(0f, 0f, CAMERA_WIDTH, CAMERA_HEIGHT, 5f, 5f, 1f)
        return EngineOptions(
            true, ScreenOrientation.PORTRAIT_FIXED,
            RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera
        )
    }

    override fun onCreateResources(p0: IGameInterface.OnCreateResourcesCallback?) {
        ResourceManager.loadBasicResources(engine, this)
        p0?.onCreateResourcesFinished()
    }

    override fun onCreateScene(p0: IGameInterface.OnCreateSceneCallback?) {
        p0?.onCreateSceneFinished(GameScene())
    }

    override fun onPopulateScene(p0: Scene?, p1: IGameInterface.OnPopulateSceneCallback?) {
        p0?.let {
            p1?.onPopulateSceneFinished()
        }
    }

}