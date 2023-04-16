package online.maestoso.dragondeleter.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonFight;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class DragonRespawnDisablerMixin {
	@Inject(method = "respawnDragon()V", at=@At("HEAD"), cancellable = true)
	public void dragon_deleter$injectRespawnDragon(CallbackInfo ci) {
		ci.cancel();
	}
}
