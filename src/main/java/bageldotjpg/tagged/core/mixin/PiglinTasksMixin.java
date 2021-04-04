package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinTasks.class)
public abstract class PiglinTasksMixin {

	@Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
	private static void isFood(Item item, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(item.is(TaggedItemTags.PIGLIN_FOOD));
	}
}