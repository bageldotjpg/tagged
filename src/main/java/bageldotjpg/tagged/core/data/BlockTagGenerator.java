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
		this.tag(TaggedBlockTags.NETHER_PORTAL_BASE_BLOCKS).add(Blocks.OBSIDIAN);
	}
}