
package net.mcreator.mauricksfirst.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.mauricksfirst.procedures.ZilverItemIsCraftedProcedure;
import net.mcreator.mauricksfirst.MauricksfirstModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@MauricksfirstModElements.ModElement.Tag
public class HamerItem extends MauricksfirstModElements.ModElement {
	@ObjectHolder("mauricksfirst:hamer")
	public static final Item block = null;
	public HamerItem(MauricksfirstModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2576;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 23f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 46;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.CAKE));
			}
		}, 3, 0f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				ItemStack retval = new ItemStack(this);
				retval.setDamage(itemstack.getDamage() + 1);
				if (retval.getDamage() >= retval.getMaxDamage()) {
					return ItemStack.EMPTY;
				}
				return retval;
			}

			@Override
			public boolean isRepairable(ItemStack itemstack) {
				return false;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("its so strong dat it kan kill a player in one hit"));
			}

			@Override
			public ActionResultType onItemUse(ItemUseContext context) {
				ActionResultType retval = super.onItemUse(context);
				World world = context.getWorld();
				BlockPos pos = context.getPos();
				PlayerEntity entity = context.getPlayer();
				Direction direction = context.getFace();
				BlockState blockstate = world.getBlockState(pos);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				ItemStack itemstack = context.getItem();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					ZilverItemIsCraftedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, blockstate, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					ZilverItemIsCraftedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onCreated(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					ZilverItemIsCraftedProcedure.executeProcedure($_dependencies);
				}
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					ZilverItemIsCraftedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("hamer"));
	}
}
