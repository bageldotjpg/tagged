package bageldotjpg.tagged.core;

import bageldotjpg.tagged.core.data.BlockTagGenerator;
import bageldotjpg.tagged.core.data.ItemTagGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Tagged.MOD_ID)
public class Tagged {
	public static final String MOD_ID = "tagged";

	public Tagged() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::dataSetup);
		MinecraftForge.EVENT_BUS.register(this);
	}
	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		BlockTagGenerator blockTagGen = new BlockTagGenerator(dataGenerator, existingFileHelper);
		dataGenerator.addProvider(new ItemTagGenerator(dataGenerator, blockTagGen, existingFileHelper));
	}
}