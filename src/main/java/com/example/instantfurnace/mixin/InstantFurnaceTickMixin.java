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
            // method_31651 é o nome interno do método tick na 1.17.1
            method = "method_31651",
            at = @At("HEAD"),
            remap = false
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

        // Faz a fornalha cozinhar em 1 tick (instantâneo).
        accessor.instantFurnace$setCookTimeTotal(1);
        accessor.instantFurnace$setCookTime(0);
        
        // Se quiser que funcione SEM combustível, descomente a linha abaixo:
        // accessor.instantFurnace$setBurnTime(200);
    }
}
