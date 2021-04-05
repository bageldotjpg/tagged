package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.inventory.container.EnchantmentContainer$3")
public abstract class EnchantmentContainerSlotMixin {

	@Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
	private void mayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(stack.getItem().is(TaggedItemTags.ENCHANTING_TABLE_PAYMENT_ITEMS));
	}
}