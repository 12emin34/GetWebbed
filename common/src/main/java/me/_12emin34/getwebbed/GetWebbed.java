package me._12emin34.getwebbed;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class GetWebbed {
    public static final String MOD_ID = "getwebbed";

    private GetWebbed() {
        throw new IllegalStateException("This class is not intended to be instantiated");
    }

    public static void init() {
        EntityEvent.LIVING_HURT.register(GetWebbed::onHurt);
    }

    private static EventResult onHurt(LivingEntity entity, DamageSource source, float amount) {
        if ((Math.random() > 0.5) && (entity instanceof Player player) && (source.getEntity() instanceof Spider)) {
            Level level = player.level();
            BlockPos above = player.getOnPos().above();
            BlockState abovePlayerPos = level.getBlockState(above);
            if (abovePlayerPos.is(Blocks.COBWEB)) {
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
            }
            level.setBlockAndUpdate(above, Blocks.COBWEB.defaultBlockState());

        }
        return EventResult.pass();
    }
}