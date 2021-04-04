package bageldotjpg.tagged.core.other;

import bageldotjpg.tagged.core.Tagged;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tagged.MOD_ID)
public class TaggedItemTags {
	public static final ITag.INamedTag<Item> FIRE_RESISTANT = createTag("fire_resistant");
	public static final ITag.INamedTag<Item> BLAST_RESISTANT = createTag("blast_resistant");
	public static final ITag.INamedTag<Item> CACTUS_RESISTANT = createTag("cactus_resistant");

	public static final ITag.INamedTag<Item> RESPAWN_ANCHOR_FUEL = createTag("respawn_anchor_fuel");

	public static final ITag.INamedTag<Item> RABBIT_TEMPT_ITEMS = createTag("rabbit_tempt_items");
	public static final ITag.INamedTag<Item> PARROT_TAME_ITEMS = createTag("parrot_tame_items");
	public static final ITag.INamedTag<Item> PARROT_POISONOUS_FOOD = createTag("parrot_poisonous_food");

	private static ITag.INamedTag<Item> createTag(String name) {
		return ItemTags.bind(Tagged.MOD_ID + ":" + name);
	}
}