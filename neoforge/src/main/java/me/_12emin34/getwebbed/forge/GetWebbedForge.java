package me._12emin34.getwebbed.forge;

import dev.architectury.platform.forge.EventBuses;
import me._12emin34.getwebbed.GetWebbed;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GetWebbed.MOD_ID)
public class GetWebbedForge {
    public GetWebbedForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GetWebbed.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GetWebbed.init();
    }
}