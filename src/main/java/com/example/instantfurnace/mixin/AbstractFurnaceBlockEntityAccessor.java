package com.example.instantfurnace.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceBlockEntity.class)
public interface AbstractFurnaceBlockEntityAccessor {

    // field_11989 = cookTime
    @Accessor(value = "field_11989", remap = false)
    void instantFurnace$setCookTime(int value);

    // field_11988 = cookTimeTotal
    @Accessor(value = "field_11988", remap = false)
    void instantFurnace$setCookTimeTotal(int value);

    // field_11981 = burnTime (combustível)
    @Accessor(value = "field_11981", remap = false)
    void instantFurnace$setBurnTime(int value);
}
