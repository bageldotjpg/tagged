package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public abstract class WolfEntityMixin extends TameableEntity {

	protected WolfEntityMixin(EntityType<? extends TameableEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
	private void isFood(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(stack.getItem().is(TaggedItemTags.WOLF_FOOD));
	}

	@Redirect(method = "mobInteract", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/item/Items;BONE:Lnet/minecraft/item/Item;"))
	private Item mobInteract() {
		return null;
	}

	@Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
	private void mobInteract(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> cir) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (this.level.isClientSide) {
			if (item.is(TaggedItemTags.WOLF_TAME_ITEMS) && !this.isTame())
				cir.setReturnValue(ActionResultType.CONSUME);
		} else if (!this.isTame() && item.is(TaggedItemTags.WOLF_TAME_ITEMS) && !((WolfEntity) (Object) this).isAngry()) {
			if (!player.abilities.instabuild) {
				itemstack.shrink(1);
			}

			if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
				this.tame(player);
				this.navigation.stop();
				this.setTarget(null);
				this.setOrderedToSit(true);
				this.level.broadcastEntityEvent(this, (byte) 7);
			} else {
				this.level.broadcastEntityEvent(this, (byte) 6);
			}

			cir.setReturnValue(ActionResultType.SUCCESS);
		}
	}
}