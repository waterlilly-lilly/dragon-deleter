package online.maestoso.dragondeleter.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;
import online.maestoso.dragondeleter.DragonDeleter;
import org.quiltmc.qsl.entity.multipart.impl.EnderDragonMultipartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonEntity.class)
public abstract class DragonDeleterMixin extends MobEntity implements Monster, EnderDragonMultipartEntity {
	protected DragonDeleterMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}

	@Shadow
	public abstract void kill();

	@Inject(method = "tickMovement", at = @At("TAIL"))
	public void dragon_deleter$injectTickMovement(CallbackInfo ci) {
		if(getWorld().getGameRules().getBoolean(DragonDeleter.DISABLE_DRAGON_SPAWNING)) {
			DragonDeleter.LOGGER.info("Dragon successfully deleted!");
			kill();
		}

	}

}
