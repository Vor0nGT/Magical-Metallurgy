package dev.vorongt.magicalmetallurgy.register;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static dev.vorongt.magicalmetallurgy.MagicalMetallurgy.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterEvents {
    private static int ticks = 1;

    // Fires every tick
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        if (player.level().isClientSide()) return;

        // Fires every second
        if(ticks != 20) {ticks += 1;}
        else {
            ticks = 1;

            // Traveling Boots effects
            if (WearingTravelingBoots(player)) {
                if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0, true, false, true));
                }
                if (!player.hasEffect(MobEffects.JUMP)) {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 0, true, false, true));
                }

                damageItem(player, "feet");
            }

            // Nightvision Glasses effects
            if (WearingNightvisionGlassses(player)) {
                if (!player.hasEffect(MobEffects.NIGHT_VISION)) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0, true, false, true));
                }

                damageItem(player, "head");
            }
        }
    }

    // Damages item
    private static void damageItem(Player player, String slot) {
        if(!player.getAbilities().instabuild) {

            ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

            if(slot.equals("head")) {
                head.hurt(1, player.getRandom(), player instanceof ServerPlayer ? (ServerPlayer) player : null);

                if (head.getDamageValue() >= head.getMaxDamage()) {
                    head.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.HEAD));
                }
            }
            else if(slot.equals("chest")) {
                chest.hurt(1, player.getRandom(), player instanceof ServerPlayer ? (ServerPlayer) player : null);

                if (chest.getDamageValue() >= chest.getMaxDamage()) {
                    chest.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
            }
            else if(slot.equals("legs")) {
                legs.hurt(1, player.getRandom(), player instanceof ServerPlayer ? (ServerPlayer) player : null);

                if (legs.getDamageValue() >= legs.getMaxDamage()) {
                    legs.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.LEGS));
                }
            }
            else if(slot.equals("feet")) {
                feet.hurt(1, player.getRandom(), player instanceof ServerPlayer ? (ServerPlayer) player : null);

                if (feet.getDamageValue() >= feet.getMaxDamage()) {
                    feet.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.FEET));
                }
            }
        }
    }

    // Checks if player wearing Traveling Boots
    private static boolean WearingTravelingBoots(Player player) {
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        return feet.getItem() == RegisterItems.TRAVELING_BOOTS.get();
    }

    // Checks if player wearing Nightvision Glasses
    private static boolean WearingNightvisionGlassses(Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);

        return head.getItem() == RegisterItems.NIGHTVISION_GLASSES.get();
    }
}
