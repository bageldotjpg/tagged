package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.inventory.container.BrewingStandContainer$FuelSlot")
public abstract class BrewingStandContainerFuelSlotMixin {

	@Inject(method = "mayPlaceItem", at = @At("HEAD"), cancellable = true)
	private static void mayPlaceItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(stack.getItem().is(TaggedItemTags.BREWING_STAND_FUEL));
	}
}