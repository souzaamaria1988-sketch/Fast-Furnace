package com.example.instantfurnace.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceBlockEntity.class)
public interface AbstractFurnaceBlockEntityAccessor {

    @Accessor(value = "cookTime", aliases = "field_11989")
    void instantFurnace$setCookTime(int value);

    @Accessor(value = "cookTimeTotal", aliases = "field_11988")
    void instantFurnace$setCookTimeTotal(int value);

    @Accessor(value = "burnTime", aliases = "field_11981")
    void instantFurnace$setBurnTime(int value);
}
