package bageldotjpg.tagged.core.data;

import bageldotjpg.tagged.core.Tagged;
import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
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

		this.tag(TaggedItemTags.BREWING_STAND_FUEL).add(Items.BLAZE_POWDER);
		this.tag(TaggedItemTags.ENCHANTING_TABLE_PAYMENT_ITEMS).add(Items.LAPIS_LAZULI);
		this.tag(TaggedItemTags.RESPAWN_ANCHOR_FUEL).add(Items.GLOWSTONE);

		this.tag(TaggedItemTags.MEAT).add(Items.BEEF, Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.MUTTON, Items.COOKED_MUTTON, Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.RABBIT, Items.COOKED_RABBIT, Items.ROTTEN_FLESH);

		this.tag(TaggedItemTags.BEE_FOOD).addTag(ItemTags.FLOWERS);
		this.tag(TaggedItemTags.CAT_FOOD).add(Items.COD, Items.SALMON);
		this.tag(TaggedItemTags.CHICKEN_FOOD).add(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
		this.tag(TaggedItemTags.COW_FOOD).add(Items.WHEAT);
		this.tag(TaggedItemTags.DOLPHIN_FOOD).addTag(ItemTags.FISHES);
		this.tag(TaggedItemTags.FOX_FOOD).add(Items.SWEET_BERRIES);
		this.tag(TaggedItemTags.HOGLIN_FOOD).add(Items.CRIMSON_FUNGUS);
		this.tag(TaggedItemTags.HORSE_FOOD).add(Items.WHEAT, Items.SUGAR, Items.HAY_BLOCK, Items.APPLE, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE);
		this.tag(TaggedItemTags.IRON_GOLEM_REPAIR_ITEMS).add(Items.IRON_INGOT);
		this.tag(TaggedItemTags.LLAMA_FOOD).add(Items.WHEAT, Items.HAY_BLOCK);
		this.tag(TaggedItemTags.OCELOT_FOOD).add(Items.COD, Items.SALMON);
		this.tag(TaggedItemTags.PARROT_POISONOUS_FOOD).add(Items.COOKIE);
		this.tag(TaggedItemTags.PARROT_TAME_ITEMS).add(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
		this.tag(TaggedItemTags.PIG_FOOD).add(Items.CARROT, Items.POTATO, Items.BEETROOT);
		this.tag(TaggedItemTags.PIGLIN_FOOD).add(Items.PORKCHOP, Items.COOKED_PORKCHOP);
		this.tag(TaggedItemTags.RABBIT_FOOD).add(Items.CARROT, Items.GOLDEN_CARROT, Items.DANDELION);
		this.tag(TaggedItemTags.SHEEP_FOOD).add(Items.WHEAT);
		this.tag(TaggedItemTags.STRIDER_FOOD).add(Items.WARPED_FUNGUS);
		this.tag(TaggedItemTags.STRIDER_TEMPT_ITEMS).addTag(TaggedItemTags.STRIDER_FOOD).add(Items.WARPED_FUNGUS_ON_A_STICK);
		this.tag(TaggedItemTags.TURTLE_FOOD).add(Items.SEAGRASS);
		this.tag(TaggedItemTags.WOLF_FOOD).addTag(TaggedItemTags.MEAT);
		this.tag(TaggedItemTags.WOLF_TAME_ITEMS).add(Items.BONE);
	}
}