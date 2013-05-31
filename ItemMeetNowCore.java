package meetnow;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemMeetNow",
	name  = "ItemMeetNow",
	version = "0.0.2"
)
@NetworkMod(
	clientSideRequired = true,
	serverSideRequired = false
)
public class ItemMeetNowCore
{
	@Instance("ItemMeetNowCore")
	public static ItemMeetNowCore instance;
	public static Item itemMeetNow = new ItemMeetNow(5000);

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}

	@Init
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.addName(itemMeetNow, "Meet Now");
		LanguageRegistry.instance().addNameForObject(itemMeetNow, "ja_JP", "今、会いにゆきます");

		GameRegistry.addRecipe(
			new ItemStack(itemMeetNow, 1),
			"   ", "xyx", "   ",
			'x', Item.enderPearl, 'y', Item.eyeOfEnder
		);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}
