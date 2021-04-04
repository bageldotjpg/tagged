package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

	@Inject(method = "hurt", at = @At(value = "HEAD"), cancellable = true)
	private void hurt(DamageSource source, float damage, CallbackInfoReturnable<Boolean> cir) {
		ItemEntity itemEntity = (ItemEntity) (Object) this;
		if (itemEntity.level.isClientSide || !itemEntity.isAlive())
			cir.setReturnValue(false);
		else if (!itemEntity.getItem().isEmpty() && itemEntity.getItem().getItem().is(TaggedItemTags.BLAST_RESISTANT) && source.isExplosion())
			cir.setReturnValue(false);
		else if (itemEntity.getItem().getItem().is(TaggedItemTags.CACTUS_RESISTANT) && source == DamageSource.CACTUS)
			cir.setReturnValue(false);
	}

	@Redirect(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"))
	private boolean isEmpty(ItemStack stack) {
		return true;
	}

}