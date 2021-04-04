package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Set;

@Mixin(ParrotEntity.class)
public abstract class ParrotEntityMixin extends ShoulderRidingEntity {

	private PlayerEntity player;
	private ItemStack stack;
	private boolean poisoned;

	protected ParrotEntityMixin(EntityType<? extends ShoulderRidingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Ljava/util/Set;contains(Ljava/lang/Object;)Z"))
	private boolean mobInteract(Set set, Object item) {
		return TaggedItemTags.PARROT_FOOD.contains((Item) item);
	}

	@Redirect(method = "mobInteract", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/entity/passive/ParrotEntity;POISONOUS_FOOD:Lnet/minecraft/item/Item;"))
	private Item mobInteract() {
		return null;
	}

	@Inject(method = "mobInteract", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/entity/passive/ParrotEntity;isFlying()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
	private void mobInteract(PlayerEntity playerEntity, Hand hand, CallbackInfoReturnable<ActionResultType> cir, ItemStack itemStack) {
		this.player = playerEntity;
		this.stack = itemStack;
	}

	@Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/ParrotEntity;isFlying()Z"))
	private boolean mobInteract(ParrotEntity parrotEntity) {
		if (!stack.getItem().is(TaggedItemTags.PARROT_POISONOUS_FOOD)) {
			return !parrotEntity.isFlying();
		}

		if (!player.abilities.instabuild) {
			stack.shrink(1);
		}

		parrotEntity.addEffect(new EffectInstance(Effects.POISON, 900));
		if (player.isCreative() || !parrotEntity.isInvulnerable()) {
			parrotEntity.hurt(DamageSource.playerAttack(player), Float.MAX_VALUE);
		}

		this.poisoned = true;
		return false;
	}

	@Inject(method = "mobInteract", at = @At(value = "RETURN", ordinal = 3), cancellable = true)
	private void mobInteract(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> cir) {
		if (poisoned) cir.setReturnValue(ActionResultType.sidedSuccess(player.level.isClientSide));
	}
}