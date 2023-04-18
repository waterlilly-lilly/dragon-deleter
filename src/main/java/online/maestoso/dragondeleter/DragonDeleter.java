package online.maestoso.dragondeleter;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;

public class DragonDeleter implements ModInitializer {
	public static Logger LOGGER = LogUtils.getLogger();
	public static GameRules.Key<GameRules.BooleanRule> DISABLE_DRAGON_SPAWNING  = GameRuleRegistry.register("disableDragonSpawning", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	public static GameRules.Key<GameRules.BooleanRule> DISABLE_DRAGON_RESPAWNING  = GameRuleRegistry.register("disableDragonRespawning", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	public static GameRules.Key<GameRules.BooleanRule> DISABLE_DRAGON_EGG_TP  = GameRuleRegistry.register("disableDragonEggTeleportation", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
	public static GameRules.Key<GameRules.BooleanRule> RESPAWN_DRAGON_EGG = GameRuleRegistry.register("respawnDragonEgg", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize(ModContainer mod) {

	}
}
