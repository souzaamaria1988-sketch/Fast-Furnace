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
            method = "tick(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;)V",
            at = @At("HEAD")
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
        // accessor.instantFurnace$setLitTime(200);
    }
}        // accessor.instantFurnace$setLitTime(200);
    }
}        
        // OPCIONAL: Se quiser que funcione SEM combustível, descomente a linha abaixo:
        // accessor.instantFurnace$setBurnTime(200);
    }
}
