package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DolphinEntity.class)
public abstract class DolphinEntityMixin {

	@Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;is(Lnet/minecraft/tags/ITag;)Z"))
	private boolean mobInteract(Item item, ITag<Item> tag) {
		return item.is(TaggedItemTags.DOLPHIN_FOOD);
	}
}