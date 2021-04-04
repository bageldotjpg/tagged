package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TaggedItemTags {
	public static final ITag.INamedTag<Item> BLAST_RESISTANT = createTag("blast_resistant");
	public static final ITag.INamedTag<Item> CACTUS_RESISTANT = createTag("cactus_resistant");
	public static final ITag.INamedTag<Item> FIRE_RESISTANT = createTag("fire_resistant");

	public static final ITag.INamedTag<Item> RESPAWN_ANCHOR_FUEL = createTag("respawn_anchor_fuel");

	public static final ITag.INamedTag<Item> CAT_FOOD = createTag("cat_food");
	public static final ITag.INamedTag<Item> CHICKEN_FOOD = createTag("chicken_food");
	public static final ITag.INamedTag<Item> COW_FOOD = createTag("cow_food");
	public static final ITag.INamedTag<Item> HOGLIN_FOOD = createTag("hoglin_food");
	public static final ITag.INamedTag<Item> RABBIT_FOOD = createTag("rabbit_food");
	public static final ITag.INamedTag<Item> PARROT_FOOD = createTag("parrot_food");
	public static final ITag.INamedTag<Item> PARROT_POISONOUS_FOOD = createTag("parrot_poisonous_food");
	public static final ITag.INamedTag<Item> PIG_FOOD = createTag("pig_food");
	public static final ITag.INamedTag<Item> PIGLIN_FOOD = createTag("piglin_food");
	public static final ITag.INamedTag<Item> SHEEP_FOOD = createTag("sheep_food");
	public static final ITag.INamedTag<Item> STRIDER_FOOD = createTag("strider_food");
	public static final ITag.INamedTag<Item> STRIDER_TEMPT_ITEMS = createTag("strider_tempt_items");

	private static ITag.INamedTag<Item> createTag(String name) {
		return ItemTags.bind(Tagged.MOD_ID + ":" + name);
	}


	/* Planned tags
	 *
	 * brewing stand fuel
	 * villager_food
	 * iron_golem_repair_items
	 * wolf_tame_items
	 * cat_tame_items
	 * dolphin_trust_items
	 * fox_food
	 * panda_food
	 * bee_food
	 * horse_food
	 * llama_food
	 * panda_tempt_items
	 * strider_food
	 *
	 */
}