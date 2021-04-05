package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(PandaEntity.class)
public abstract class PandaEntityMixin extends AnimalEntity {

	private static final Predicate<ItemEntity> PANDA_ITEMS = (itemEntity) -> {
		Item item = itemEntity.getItem().getItem();
		return (item.is(TaggedItemTags.PANDA_SNACKS)) && itemEntity.isAlive() && !itemEntity.hasPickUpDelay();
	};

	protected PandaEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Redirect(method = "registerGoals", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/GoalSelector;addGoal(ILnet/minecraft/entity/ai/goal/Goal;)V", ordinal = 4))
	private void registerGoals(GoalSelector goalSelector, int priority, Goal goal) {
		goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(TaggedItemTags.PANDA_FOOD), false));
	}

	@Redirect(method = "pickUpItem", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/entity/passive/PandaEntity;PANDA_ITEMS:Ljava/util/function/Predicate;"))
	private Predicate<ItemEntity> mobInteract() {
		return PANDA_ITEMS;
	}


	@Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
	private void isFood(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(TaggedItemTags.PANDA_FOOD.contains(stack.getItem()));
	}

	@Inject(method = "isFoodOrCake", at = @At("HEAD"), cancellable = true)
	private void isFoodOrCake(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(TaggedItemTags.PANDA_SNACKS.contains(stack.getItem()));
	}
}