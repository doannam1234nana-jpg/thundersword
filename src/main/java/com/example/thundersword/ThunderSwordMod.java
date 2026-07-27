package com.example.thundersword;

import com.example.thundersword.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod(ThunderSwordMod.MOD_ID)
public class ThunderSwordMod {

    public static final String MOD_ID = "thundersword";

    public ThunderSwordMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register our deferred registers with the mod event bus
        ModItems.ITEMS.register(modEventBus);
    }

    // Adds our item to the vanilla "Combat" creative tab so players can find it easily
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
            if (event.getTabKey() == CreativeModeTabs.COMBAT) {
                event.accept(ModItems.THUNDER_SWORD);
            }
        }
    }
}
