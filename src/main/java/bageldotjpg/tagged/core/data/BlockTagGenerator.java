package bageldotjpg.tagged.core.data;

import bageldotjpg.tagged.core.Tagged;
import bageldotjpg.tagged.core.other.TaggedBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Tagged.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(TaggedBlockTags.CONDUIT_BASE_BLOCKS).add(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.SEA_LANTERN, Blocks.DARK_PRISMARINE);
		this.tag(TaggedBlockTags.IRON_GOLEM_BASE_BLOCKS).add(Blocks.IRON_BLOCK);
		this.tag(TaggedBlockTags.NETHER_PORTAL_BASE_BLOCKS).add(Blocks.OBSIDIAN);
		this.tag(TaggedBlockTags.SNOW_GOLEM_BASE_BLOCKS).add(Blocks.SNOW_BLOCK);

		this.tag(TaggedBlockTags.DUNGEON_PRIMARY_BLOCKS).add(Blocks.COBBLESTONE);
		this.tag(TaggedBlockTags.DUNGEON_SECONDARY_BLOCKS).add(Blocks.MOSSY_COBBLESTONE);

		this.tag(TaggedBlockTags.IMMOVABLE_BY_PISTON).add(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.RESPAWN_ANCHOR);

	}
}