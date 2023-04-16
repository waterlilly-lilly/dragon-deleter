package online.maestoso.dragondeleter.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import online.maestoso.dragondeleter.DragonDeleter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DragonEggBlock.class)
public abstract class DisableDragonEggTeleportationMixin extends FallingBlock {
	public DisableDragonEggTeleportationMixin(Settings settings, CallbackInfo ci) {
		super(settings);
	}
	@ModifyVariable(method = "<init>", at = @At("HEAD"), argsOnly = true)
	private static Settings dragon_deleter$injectInit(Settings settings) {
		return Settings.of(Material.EGG, MapColor.BLACK).strength(-1.0F, 3600000.0F).luminance(state -> 1).nonOpaque();
	}

	@Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
	public void dragon_deleter$injectOnUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
		if(world.getGameRules().getBoolean(DragonDeleter.DISABLE_DRAGON_EGG_TP))
			cir.setReturnValue(ActionResult.PASS);
	}
	@Inject(method = "onBlockBreakStart", at = @At("HEAD"), cancellable = true)
	public void dragon_deleter$injectOnBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player, CallbackInfo ci) {
		if(world.getGameRules().getBoolean(DragonDeleter.DISABLE_DRAGON_EGG_TP))
			ci.cancel();
	}

}
