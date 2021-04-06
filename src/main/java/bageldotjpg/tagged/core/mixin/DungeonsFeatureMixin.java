package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.DungeonsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(DungeonsFeature.class)
public abstract class DungeonsFeatureMixin {

	@Redirect(method = "place", at = @At(value = "INVOKE", ordinal = 3, target = "Lnet/minecraft/world/ISeedReader;setBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
	private boolean setPrimaryBlock(ISeedReader world, BlockPos pos, BlockState state, int flags) {
		Random random = world.getRandom();
		BlockState newState = TaggedBlockTags.DUNGEON_PRIMARY_BLOCKS.getRandomElement(random).defaultBlockState();
		return world.setBlock(pos, newState, flags);
	}

	@Redirect(method = "place", at = @At(value = "INVOKE", ordinal = 2, target = "Lnet/minecraft/world/ISeedReader;setBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
	private boolean setSecondaryBlock(ISeedReader world, BlockPos pos, BlockState state, int flags) {
		Random random = world.getRandom();
		BlockState newState = TaggedBlockTags.DUNGEON_SECONDARY_BLOCKS.getRandomElement(random).defaultBlockState();
		return world.setBlock(pos, newState, flags);
	}
}