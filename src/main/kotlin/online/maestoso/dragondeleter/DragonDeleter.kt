package online.maestoso.dragondeleter

import org.slf4j.Logger
import com.mojang.logging.LogUtils
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry
import net.minecraft.world.GameRules
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object DragonDeleter : ModInitializer {
    @JvmField val LOGGER: Logger = LogUtils.getLogger()
    @JvmField val DISABLE_DRAGON_SPAWNING: GameRules.Key<GameRules.BooleanRule> = GameRuleRegistry.register("disableDragonSpawning", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true))
    @JvmField val DISABLE_DRAGON_RESPAWNING: GameRules.Key<GameRules.BooleanRule> = GameRuleRegistry.register("disableDragonRespawning", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true))
    @JvmField val DISABLE_DRAGON_EGG_TP: GameRules.Key<GameRules.BooleanRule> = GameRuleRegistry.register("disableDragonEggTeleportation", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true))
    @JvmField val RESPAWN_DRAGON_EGG: GameRules.Key<GameRules.BooleanRule> = GameRuleRegistry.register("respawnDragonEgg", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true))
    override fun onInitialize(mod: ModContainer?) {
    }
}
