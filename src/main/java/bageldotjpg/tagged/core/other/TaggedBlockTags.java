package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.fml.common.Mod;

public class TaggedBlockTags {
	public static final ITag.INamedTag<Block> CONDUIT_BASE_BLOCKS = createTag("conduit_base_blocks");
	public static final ITag.INamedTag<Block> NETHER_PORTAL_BASE_BLOCKS = createTag("nether_portal_base_blocks");

	private static ITag.INamedTag<Block> createTag(String name) {
		return BlockTags.bind(Tagged.MOD_ID + ":" + name);
	}
}