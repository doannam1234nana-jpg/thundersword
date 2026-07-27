package com.example.thundersword.item;

import com.example.thundersword.ThunderSwordMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThunderSwordMod.MOD_ID);

    public static final RegistryObject<Item> THUNDER_SWORD = ITEMS.register("thunder_sword",
            () -> new ThunderSwordItem(
                    ThunderTier.INSTANCE,
                    3,      // base attack damage modifier (on top of tier bonus)
                    -2.4F,  // attack speed modifier (same as vanilla swords)
                    new Item.Properties()
            ));
}
