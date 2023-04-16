package online.maestoso.dragondeleter.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.server.world.ServerWorld;
import online.maestoso.dragondeleter.DragonDeleter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class DragonRespawnDisablerMixin {
	@Shadow
	@Final
	private ServerWorld world;

	@Inject(method = "respawnDragon()V", at=@At("HEAD"), cancellable = true)
	public void dragon_deleter$injectRespawnDragon(CallbackInfo ci) {
		if(world.getGameRules().getBoolean(DragonDeleter.DISABLE_DRAGON_RESPAWNING))
			ci.cancel();
	}
}
