package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.AbstractBlock.IPositionPredicate;
import net.minecraft.block.PortalSize;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PortalSize.class)
public abstract class PortalSizeMixin {

	@Redirect(method = "getDistanceUntilEdgeAboveFrame", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/block/PortalSize;FRAME:Lnet/minecraft/block/AbstractBlock$IPositionPredicate;"))
	private IPositionPredicate getDistanceUntilEdgeAboveFrame() {
		return (state, reader, pos) -> state.is(TaggedBlockTags.NETHER_PORTAL_BASE_BLOCKS);
	}

	@Redirect(method = "hasTopFrame", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/block/PortalSize;FRAME:Lnet/minecraft/block/AbstractBlock$IPositionPredicate;"))
	private IPositionPredicate hasTopFrame() {
		return (state, reader, pos) -> state.is(TaggedBlockTags.NETHER_PORTAL_BASE_BLOCKS);
	}

	@Redirect(method = "getDistanceUntilTop", at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/block/PortalSize;FRAME:Lnet/minecraft/block/AbstractBlock$IPositionPredicate;"))
	private IPositionPredicate getDistanceUntilTop() {
		return (state, reader, pos) -> state.is(TaggedBlockTags.NETHER_PORTAL_BASE_BLOCKS);
	}
}