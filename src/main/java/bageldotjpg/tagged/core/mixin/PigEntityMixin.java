package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PigEntity.class)
public abstract class PigEntityMixin {

	@Redirect(method = "registerGoals", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/entity/passive/PigEntity;FOOD_ITEMS:Lnet/minecraft/item/crafting/Ingredient;"))
	private Ingredient registerGoals() {
		return Ingredient.of(TaggedItemTags.PIG_FOOD);
	}

	@Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
	private void isFood(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(TaggedItemTags.PIG_FOOD.contains(stack.getItem()));
	}
}