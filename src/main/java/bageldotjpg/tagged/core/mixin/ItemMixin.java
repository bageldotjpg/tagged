package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

	@Inject(method = "isFireResistant", at = @At("HEAD"), cancellable = true)
	private void isFireResistant(CallbackInfoReturnable<Boolean> cir) {
		Item item = (Item) (Object) this;
		cir.setReturnValue(item.is(TaggedItemTags.FIRE_RESISTANT));
	}

	@Inject(method = "canBeHurtBy", at = @At("HEAD"), cancellable = true)
	private void canBeHurtBy(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
		Item item = (Item) (Object) this;
		cir.setReturnValue(!item.is(TaggedItemTags.FIRE_RESISTANT) || !source.isFire());
	}
}