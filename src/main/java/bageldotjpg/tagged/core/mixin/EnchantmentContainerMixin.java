package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.EnchantmentContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(EnchantmentContainer.class)
public abstract class EnchantmentContainerMixin extends Container {

	protected EnchantmentContainerMixin(@Nullable ContainerType<?> containerType, int i) {
		super(containerType, i);
	}

	@Inject(method = "quickMoveStack", at = @At("HEAD"), cancellable = true)
	private void quickMoveStack(PlayerEntity player, int index, CallbackInfoReturnable<ItemStack> cir) {
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack stack = slot.getItem();
			if (index != 0 && index != 1 && stack.getItem().is(TaggedItemTags.ENCHANTING_TABLE_PAYMENT_ITEMS)) {
				if (!this.moveItemStackTo(stack, 1, 2, true)) {
					cir.setReturnValue(ItemStack.EMPTY);
				}
			}
		}
	}

	@Redirect(method = "quickMoveStack", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/item/Items;LAPIS_LAZULI:Lnet/minecraft/item/Item;"))
	private Item tick() {
		return null;
	}
}