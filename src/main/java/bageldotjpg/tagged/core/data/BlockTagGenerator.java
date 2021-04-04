package bageldotjpg.tagged.core.data;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Tagged.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
	}
}