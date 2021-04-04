package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RespawnAnchorBlock.class)
public abstract class RespawnAnchorBlockMixin {

	@Inject(method = "isRespawnFuel", at = @At(value = "HEAD"), cancellable = true)
	private static void isRespawnFuel(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(stack.getItem().is(TaggedItemTags.RESPAWN_ANCHOR_FUEL));
	}
}