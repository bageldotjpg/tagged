package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BrewingStandTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingStandTileEntity.class)
public abstract class BrewingStandTileEntityMixin extends LockableTileEntity {

	@Shadow
	private NonNullList<ItemStack> items;

	@Shadow
	private int fuel;

	protected BrewingStandTileEntityMixin(TileEntityType<?> tileEntityType) {
		super(tileEntityType);
	}

	@Redirect(method = "tick", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/item/Items;BLAZE_POWDER:Lnet/minecraft/item/Item;"))
	private Item tick() {
		return null;
	}

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	private void tick(CallbackInfo ci) {
		ItemStack itemstack = this.items.get(4);
		if (this.fuel <= 0 && itemstack.getItem().is(TaggedItemTags.BREWING_STAND_FUEL)) {
			this.fuel = 20;
			itemstack.shrink(1);
			this.setChanged();
		}
	}

	@Inject(method = "canPlaceItem", at = @At("HEAD"), cancellable = true)
	private void canPlaceItem(int slot, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (slot == 4) {
			Item item = stack.getItem();
			cir.setReturnValue(item.is(TaggedItemTags.BREWING_STAND_FUEL));
		}
	}
}