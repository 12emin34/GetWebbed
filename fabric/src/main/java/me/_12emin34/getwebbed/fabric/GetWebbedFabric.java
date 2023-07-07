package me._12emin34.getwebbed.fabric;

import me._12emin34.getwebbed.GetWebbed;
import net.fabricmc.api.ModInitializer;

public class GetWebbedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GetWebbed.init();
    }
}