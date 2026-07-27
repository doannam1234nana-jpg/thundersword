package com.example.thundersword.item;

import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

/**
 * A custom tool tier stronger than diamond, used only by the Thunder Sword.
 * We delegate most numbers to diamond but raise damage/durability slightly
 * and require a diamond as the repair ingredient.
 */
public enum ThunderTier implements Tier {
    INSTANCE;

    @Override
    public int getUses() {
        return 2031; // a bit tougher than diamond (1561)
    }

    @Override
    public float getSpeed() {
        return Tiers.DIAMOND.getSpeed();
    }

    @Override
    public float getAttackDamageBonus() {
        return Tiers.DIAMOND.getAttackDamageBonus() + 1.0F;
    }

    @Override
    public int getLevel() {
        return Tiers.DIAMOND.getLevel();
    }

    @Override
    public int getEnchantmentValue() {
        return 12; // slightly better than diamond's 10
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.DIAMOND);
    }
}
