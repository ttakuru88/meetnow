package meetnow;

import java.util.List;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;

public class ItemMeetNow extends Item
{
	public ItemMeetNow(int itemId)
	{
		super(itemId);

		maxStackSize = 16;
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		List players = par3World.playerEntities;
		Random rand = new Random();
		EntityPlayer player = (EntityPlayer)players.get(rand.nextInt(players.size()));

		if(player.username.equals(par2EntityPlayer.username)){
			return true;
		}

		par2EntityPlayer.setPosition(player.posX, player.posY, player.posZ);
		par1ItemStack.stackSize -= 1;

		return true;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("meetnow:meet");
	}
}
