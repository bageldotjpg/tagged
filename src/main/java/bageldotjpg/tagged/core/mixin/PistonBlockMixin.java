package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonBlock.class)
public abstract class PistonBlockMixin {

	@Redirect(method = "isPushable", at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/block/BlockState;is(Lnet/minecraft/block/Block;)Z"))
	private static boolean isImmovableByPiston(BlockState state, Block block) {
		return state.is(TaggedBlockTags.IMMOVABLE_BY_PISTON);
	}

	@Redirect(method = "isPushable", at = @At(value = "INVOKE", ordinal = 1, target = "Lnet/minecraft/block/BlockState;is(Lnet/minecraft/block/Block;)Z"))
	private static boolean isCryingObsidian(BlockState state, Block block) {
		return false;
	}

	@Redirect(method = "isPushable", at = @At(value = "INVOKE", ordinal = 2, target = "Lnet/minecraft/block/BlockState;is(Lnet/minecraft/block/Block;)Z"))
	private static boolean isRespawnAnchor(BlockState state, Block block) {
		return false;
	}
}