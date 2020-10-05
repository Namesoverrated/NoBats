package com.filler.nobats.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;

@Mixin(BatEntity.class)
public class NoBats {
	@Inject(method = "canSpawn", at = @At("HEAD"), cancellable = true)
	private static void canSpawn(EntityType<? extends BatEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable info) {
		if (type.equals(EntityType.BAT)){
			info.setReturnValue(false);
			info.cancel();
		}
	}
}
