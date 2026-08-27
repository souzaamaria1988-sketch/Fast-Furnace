package com.example.instantfurnace.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceBlockEntity.class)
public interface AbstractFurnaceBlockEntityAccessor {

    @Accessor("cookTime")
    void instantFurnace$setCookTime(int value);

    @Accessor("cookTimeTotal")
    void instantFurnace$setCookTimeTotal(int value);

    // Na 1.17.1 o nome correto é burnTime, e não litTime!
    @Accessor("burnTime")
    void instantFurnace$setBurnTime(int value);
}
