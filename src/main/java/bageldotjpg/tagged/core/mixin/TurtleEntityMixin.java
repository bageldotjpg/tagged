package bageldotjpg.tagged.core.mixin;

import bageldotjpg.tagged.core.other.TaggedItemTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TurtleEntity.class)
public abstract class TurtleEntityMixin extends AnimalEntity {

	// TODO: Turtle tempt goal
	protected TurtleEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem().is(TaggedItemTags.TURTLE_FOOD);
	}
}