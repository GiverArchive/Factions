package me.giverplay.factions.command.commands;

import me.giverplay.factions.command.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AreaCommand extends AbstractCommand
{
  public AreaCommand()
  {
    super("area");
    register();
  }
  
  @Override
  public boolean run(Player player, String[] args)
  {
    Inventory inv = Bukkit.createInventory(null, 54, "Invzinho");
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
    
    for(int i = 0; i < inv.getSize(); i++)
    {
      if(i < 9 || i >= inv.getSize() - 9)
      {
        inv.setItem(i, vidro);
      }
      else if(i % 9 == 0)
      {
        inv.setItem(i, vidro);
        inv.setItem(i + 8, vidro);
      }
    }
    
    inv.setItem(25, new ItemStack(Material.INK_SACK, 1, (short) 10));
    
    player.openInventory(inv);
    
    return true;
  }
}
