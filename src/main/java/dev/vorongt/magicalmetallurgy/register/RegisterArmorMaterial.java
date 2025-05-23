package dev.vorongt.magicalmetallurgy.register;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static dev.vorongt.magicalmetallurgy.MagicalMetallurgy.MODID;

public class RegisterArmorMaterial {
    public enum ModArmorMaterials implements ArmorMaterial {
        SHINESTEEL_ARMOR("shinesteel_armor", 1, new int[]{2, 0, 0, 2}, 0,
                SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(Items.IRON_INGOT));
        private static final int[] BASE_DURABILITY = {300, 1, 1, 300};
        private final String name;
        private final int durabilityMultiplier;
        private final int[] protectionAmounts;
        private final int enchantability;
        private final SoundEvent equipSound;
        private final float toughness;
        private final float knockbackResistance;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                          SoundEvent equipSound, float toughness, float knockbackResistance,
                          Supplier<Ingredient> repairIngredient) {
            this.name = name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.protectionAmounts = protectionAmounts;
            this.enchantability = enchantability;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        }


        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return this.protectionAmounts[type.ordinal()];
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return this.equipSound;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }

        @Override
        public String getName() {
            return MODID + ":" + this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }

}
