package com.filler.nostriders.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;

@Mixin(StriderEntity.class)
public class NoStriders {
	@Inject(method = "canSpawn", at = @At("HEAD"), cancellable = true)
	private static void canSpawn(EntityType<? extends StriderEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable info) {
		if (type.equals(EntityType.STRIDER)){
			info.setReturnValue(false);
			info.cancel();
		}
	}
}
