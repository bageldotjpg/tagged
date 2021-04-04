package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TaggedItemTags {
	public static final ITag.INamedTag<Item> FIRE_RESISTANT = createTag("fire_resistant");
	public static final ITag.INamedTag<Item> BLAST_RESISTANT = createTag("blast_resistant");
	public static final ITag.INamedTag<Item> CACTUS_RESISTANT = createTag("cactus_resistant");

	public static final ITag.INamedTag<Item> RESPAWN_ANCHOR_FUEL = createTag("respawn_anchor_fuel");

	public static final ITag.INamedTag<Item> RABBIT_FOOD = createTag("rabbit_food");
	public static final ITag.INamedTag<Item> PARROT_TAME_ITEMS = createTag("parrot_tame_items");
	public static final ITag.INamedTag<Item> PARROT_POISONOUS_FOOD = createTag("parrot_poisonous_food");
	public static final ITag.INamedTag<Item> PIG_FOOD = createTag("pig_food");
	public static final ITag.INamedTag<Item> PIGLIN_FOOD = createTag("piglin_food");

	private static ITag.INamedTag<Item> createTag(String name) {
		return ItemTags.bind(Tagged.MOD_ID + ":" + name);
	}


	/* Planned tags
	 *
	 * villager_food
	 * iron_golem_repair_items
	 * wolf_tame_items
	 * cat_tame_items
	 * dolphin_trust_items
	 * fox_food
	 * panda_food
	 * bee_food
	 * cat_food
	 * chicken_food
	 * cow_food
	 * hoglin_food
	 * horse_food
	 * llama_food
	 * panda_tempt_items
	 * sheep_food
	 * strider_food
	 *
	 */
}