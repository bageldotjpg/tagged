package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ConduitTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ConduitTileEntity.class)
public abstract class ConduitTileEntityMixin {

	@Redirect(method = "updateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isConduitFrame(Lnet/minecraft/world/IWorldReader;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;)Z"))
	private boolean updateShape(BlockState state, IWorldReader world, BlockPos pos, BlockPos conduit) {
		return state.is(TaggedBlockTags.CONDUIT_BASE_BLOCKS);
	}
}