package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.entity.passive.TurtleEntity$PlayerTemptGoal")
public abstract class TurtleEntityPlayerTemptGoalMixin {

	@Inject(method = "shouldFollowItem", at = @At("HEAD"), cancellable = true)
	private void shouldFollowItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(stack.getItem().is(TaggedItemTags.TURTLE_FOOD));
	}
}