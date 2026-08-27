package com.example.instantfurnace.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class InstantFurnaceTickMixin {

    @Inject(
            method = {
                "tick(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;)V",
                "method_31651(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;Lnet/minecraft/class_2609;)V"
            },
            at = @At("HEAD"),
            remap = false,
            require = 1
    )
    private static void instantFurnace$forceInstant(
            World world,
            BlockPos pos,
            BlockState state,
            AbstractFurnaceBlockEntity furnace,
            CallbackInfo ci
    ) {
        if (world.isClient) {
            return;
        }

        AbstractFurnaceBlockEntityAccessor accessor = (AbstractFurnaceBlockEntityAccessor) furnace;

        accessor.instantFurnace$setCookTimeTotal(1);
        accessor.instantFurnace$setCookTime(0);
    }
}
