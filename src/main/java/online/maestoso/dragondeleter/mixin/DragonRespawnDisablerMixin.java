package online.maestoso.dragondeleter.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.EndPortalFeature;
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
	@Shadow
	private boolean previouslyKilled;
	@Shadow
	private boolean dragonKilled;

	@Inject(method = "respawnDragon()V", at=@At("HEAD"), cancellable = true)
	public void dragon_deleter$injectRespawnDragon(CallbackInfo ci) {
		if(world.getGameRules().getBoolean(DragonDeleter.DISABLE_DRAGON_RESPAWNING))
			ci.cancel();
	}
	@Inject(method = "dragonKilled(Lnet/minecraft/entity/boss/dragon/EnderDragonEntity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/boss/dragon/EnderDragonFight;generateNewEndGateway()V"), cancellable = true)
	public void dragon_deleter$injectDragonKilled(CallbackInfo ci) {
		if(world.getGameRules().getBoolean(DragonDeleter.RESPAWN_DRAGON_EGG) || !this.previouslyKilled) {
			this.world.setBlockState(this.world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, EndPortalFeature.ORIGIN), Blocks.DRAGON_EGG.getDefaultState());
		}
		this.previouslyKilled = true;
		this.dragonKilled = true;
		ci.cancel();
	}

}
