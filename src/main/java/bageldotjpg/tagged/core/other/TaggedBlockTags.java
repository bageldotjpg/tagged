package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;

public class TaggedBlockTags {
	public static final ITag.INamedTag<Block> CONDUIT_BASE_BLOCKS = createTag("conduit_base_blocks");
	public static final ITag.INamedTag<Block> IRON_GOLEM_BASE_BLOCKS = createTag("iron_golem_base_blocks");
	public static final ITag.INamedTag<Block> NETHER_PORTAL_BASE_BLOCKS = createTag("nether_portal_base_blocks");
	public static final ITag.INamedTag<Block> SNOW_GOLEM_BASE_BLOCKS = createTag("snow_golem_base_blocks");

	public static final ITag.INamedTag<Block> DUNGEON_PRIMARY_BLOCKS = createTag("dungeon_primary_blocks");
	public static final ITag.INamedTag<Block> DUNGEON_SECONDARY_BLOCKS = createTag("dungeon_secondary_blocks");

	public static final ITag.INamedTag<Block> IMMOVABLE_BY_PISTON = createTag("immovable_by_piston");

	private static ITag.INamedTag<Block> createTag(String name) {
		return BlockTags.bind(Tagged.MOD_ID + ":" + name);
	}
}