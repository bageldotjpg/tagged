package bageldotjpg.tagged.core.data;

import bageldotjpg.tagged.core.Tagged;
import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGenerator extends ItemTagsProvider {
	public ItemTagGenerator(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(generator, blockTagsProvider, Tagged.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(TaggedItemTags.BLAST_RESISTANT).add(Items.NETHER_STAR);
		this.tag(TaggedItemTags.CACTUS_RESISTANT);
		this.tag(TaggedItemTags.FIRE_RESISTANT).add(Items.NETHERITE_INGOT, Items.NETHERITE_SCRAP, Items.NETHERITE_SWORD, Items.NETHERITE_SHOVEL, Items.NETHERITE_PICKAXE, Items.NETHERITE_AXE, Items.NETHERITE_HOE, Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS, Items.NETHERITE_BLOCK, Items.ANCIENT_DEBRIS);

		this.tag(TaggedItemTags.RESPAWN_ANCHOR_FUEL).add(Items.GLOWSTONE);

		this.tag(TaggedItemTags.CHICKEN_FOOD).add(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
		this.tag(TaggedItemTags.HOGLIN_FOOD).add(Items.CRIMSON_FUNGUS);
		this.tag(TaggedItemTags.RABBIT_FOOD).add(Items.CARROT, Items.GOLDEN_CARROT, Items.DANDELION);
		this.tag(TaggedItemTags.PARROT_POISONOUS_FOOD).add(Items.COOKIE);
		this.tag(TaggedItemTags.PARROT_TAME_ITEMS).add(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
		this.tag(TaggedItemTags.PIG_FOOD).add(Items.CARROT, Items.POTATO, Items.BEETROOT);
		this.tag(TaggedItemTags.PIGLIN_FOOD).add(Items.PORKCHOP, Items.COOKED_PORKCHOP);
	}
}