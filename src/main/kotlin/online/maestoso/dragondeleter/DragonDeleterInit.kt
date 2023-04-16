package online.maestoso.dragondeleter

import com.mojang.logging.LogUtils
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object DragonDeleterInit : ModInitializer {
    @JvmField val LOGGER = LogUtils.getLogger()
    override fun onInitialize(mod: ModContainer?) {}
}
