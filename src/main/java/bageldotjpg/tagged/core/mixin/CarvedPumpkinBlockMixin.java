package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.util.CachedBlockInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin {

	@Shadow
	@Nullable
	private BlockPattern snowGolemBase;

	@Shadow
	@Nullable
	private BlockPattern snowGolemFull;

	@Shadow
	@Nullable
	private BlockPattern ironGolemBase;

	@Shadow
	@Nullable
	private BlockPattern ironGolemFull;

	@Shadow
	@Final
	private static Predicate<BlockState> PUMPKINS_PREDICATE;

	@Inject(method = "getOrCreateSnowGolemBase", at = @At("HEAD"), cancellable = true)
	private void getOrCreateSnowGolemBase(CallbackInfoReturnable<BlockPattern> cir) {
		if (this.snowGolemBase == null)
			this.snowGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', (state) -> state.getState().is(TaggedBlockTags.SNOW_GOLEM_BASE_BLOCKS)).build();
		cir.setReturnValue(this.snowGolemBase);
	}

	@Inject(method = "getOrCreateSnowGolemFull", at = @At("HEAD"), cancellable = true)
	private void getOrCreateSnowGolemFull(CallbackInfoReturnable<BlockPattern> cir) {
		if (this.snowGolemFull == null) {
			this.snowGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', CachedBlockInfo.hasState(PUMPKINS_PREDICATE)).where('#', (state) -> state.getState().is(TaggedBlockTags.SNOW_GOLEM_BASE_BLOCKS)).build();
		}

		cir.setReturnValue(this.snowGolemFull);
	}

	@Inject(method = "getOrCreateIronGolemBase", at = @At("HEAD"), cancellable = true)
	private void getOrCreateIronGolemBase(CallbackInfoReturnable<BlockPattern> cir) {
		if (this.ironGolemBase == null) {
			this.ironGolemBase = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', (state) -> state.getState().is(TaggedBlockTags.IRON_GOLEM_BASE_BLOCKS)).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
		}

		cir.setReturnValue(this.ironGolemBase);
	}

	@Inject(method = "getOrCreateIronGolemFull", at = @At("HEAD"), cancellable = true)
	private void getOrCreateIronGolemFull(CallbackInfoReturnable<BlockPattern> cir) {
		if (this.ironGolemFull == null) {
			this.ironGolemFull = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', CachedBlockInfo.hasState(PUMPKINS_PREDICATE)).where('#', (state) -> state.getState().is(TaggedBlockTags.IRON_GOLEM_BASE_BLOCKS)).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
		}

		cir.setReturnValue(this.ironGolemFull);
	}
}