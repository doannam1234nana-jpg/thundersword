package com.example.thundersword.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;

import java.util.Random;

public class ThunderSwordItem extends SwordItem {

    // 25% chance per hit to call down a lightning bolt on the target.
    private static final float STRIKE_CHANCE = 0.25F;
    private static final Random RANDOM = new Random();

    public ThunderSwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        Level level = attacker.level();
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            if (RANDOM.nextFloat() < STRIKE_CHANCE) {
                LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (bolt != null) {
                    // Visual-only bolt that doesn't start fires or grief the world;
                    // it still deals vanilla lightning damage to the entity it strikes.
                    bolt.setVisualOnly(false);
                    bolt.moveTo(target.getX(), target.getY(), target.getZ());
                    serverLevel.addFreshEntity(bolt);
                }
            }
        }

        return result;
    }
}
