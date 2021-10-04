
package net.mcreator.mauricksfirst.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.mauricksfirst.MauricksfirstModElements;

@MauricksfirstModElements.ModElement.Tag
public class McarmorItem extends MauricksfirstModElements.ModElement {
	@ObjectHolder("mauricksfirst:mcarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("mauricksfirst:mcarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("mauricksfirst:mcarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("mauricksfirst:mcarmor_boots")
	public static final Item boots = null;
	public McarmorItem(MauricksfirstModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 52;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 100;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.loop"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.NETHERITE_BOOTS), new ItemStack(Items.NETHERITE_CHESTPLATE),
						new ItemStack(Items.NETHERITE_LEGGINGS), new ItemStack(Items.NETHERITE_HELMET), new ItemStack(Items.DIAMOND_HELMET),
						new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(Items.DIAMOND_BOOTS),
						new ItemStack(Items.GOLDEN_HELMET), new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(Items.GOLDEN_CHESTPLATE),
						new ItemStack(Items.GOLDEN_LEGGINGS), new ItemStack(Items.GOLDEN_BOOTS));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "mcarmor";
			}

			@Override
			public float getToughness() {
				return 4.1000000000000005f;
			}

			@Override
			public float getKnockbackResistance() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mauricksfirst:textures/models/armor/mcarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("mcarmor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mauricksfirst:textures/models/armor/mcarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("mcarmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mauricksfirst:textures/models/armor/mcarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("mcarmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "mauricksfirst:textures/models/armor/mcarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("mcarmor_boots"));
	}
}
