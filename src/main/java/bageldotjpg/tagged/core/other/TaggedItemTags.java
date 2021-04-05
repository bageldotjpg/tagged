package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TaggedItemTags {
	public static final ITag.INamedTag<Item> BLAST_RESISTANT = createTag("blast_resistant");
	public static final ITag.INamedTag<Item> CACTUS_RESISTANT = createTag("cactus_resistant");
	public static final ITag.INamedTag<Item> FIRE_RESISTANT = createTag("fire_resistant");

	public static final ITag.INamedTag<Item> MEAT = createTag("meat");

	public static final ITag.INamedTag<Item> BREWING_STAND_FUEL = createTag("brewing_stand_fuel");
	public static final ITag.INamedTag<Item> ENCHANTING_TABLE_PAYMENT_ITEMS = createTag("enchanting_table_payment_items");
	public static final ITag.INamedTag<Item> RESPAWN_ANCHOR_FUEL = createTag("respawn_anchor_fuel");

	public static final ITag.INamedTag<Item> BEE_FOOD = createTag("bee_food");
	public static final ITag.INamedTag<Item> CAT_FOOD = createTag("cat_food");
	public static final ITag.INamedTag<Item> CHICKEN_FOOD = createTag("chicken_food");
	public static final ITag.INamedTag<Item> COW_FOOD = createTag("cow_food");
	public static final ITag.INamedTag<Item> DOLPHIN_FOOD = createTag("dolphin_food");
	public static final ITag.INamedTag<Item> FOX_FOOD = createTag("fox_food");
	public static final ITag.INamedTag<Item> HOGLIN_FOOD = createTag("hoglin_food");
	public static final ITag.INamedTag<Item> HORSE_FOOD = createTag("horse_food");
	public static final ITag.INamedTag<Item> IRON_GOLEM_REPAIR_ITEMS = createTag("iron_golem_repair_items");
	public static final ITag.INamedTag<Item> LLAMA_FOOD = createTag("llama_food");
	public static final ITag.INamedTag<Item> OCELOT_FOOD = createTag("ocelot_food");
	public static final ITag.INamedTag<Item> PARROT_POISONOUS_FOOD = createTag("parrot_poisonous_food");
	public static final ITag.INamedTag<Item> PARROT_TAME_ITEMS = createTag("parrot_tame_items");
	public static final ITag.INamedTag<Item> PIG_FOOD = createTag("pig_food");
	public static final ITag.INamedTag<Item> PIGLIN_FOOD = createTag("piglin_food");
	public static final ITag.INamedTag<Item> RABBIT_FOOD = createTag("rabbit_food");
	public static final ITag.INamedTag<Item> SHEEP_FOOD = createTag("sheep_food");
	public static final ITag.INamedTag<Item> STRIDER_FOOD = createTag("strider_food");
	public static final ITag.INamedTag<Item> STRIDER_TEMPT_ITEMS = createTag("strider_tempt_items");
	public static final ITag.INamedTag<Item> TURTLE_FOOD = createTag("turtle_food");
	public static final ITag.INamedTag<Item> WOLF_FOOD = createTag("wolf_food");
	public static final ITag.INamedTag<Item> WOLF_TAME_ITEMS = createTag("wolf_tame_items");

	private static ITag.INamedTag<Item> createTag(String name) {
		return ItemTags.bind(Tagged.MOD_ID + ":" + name);
	}


	/* Planned tags
	 *
	 * villager_food
	 * panda_food
	 * panda_tempt_items
	 *
	 */
}