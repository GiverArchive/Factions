package me.giverplay.factions.area;

import me.giverplay.factions.Factions;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.configuration.file.FileConfiguration;

public class AreaManager
{
  private final Factions factions;
  private final SimpleClans clans;
  
  private FileConfiguration config;
  
  public AreaManager(Factions factions, SimpleClans simpleClans)
  {
    this.factions = factions;
    this.clans = simpleClans;
    
    start();
  }
  
  private void start()
  {
    config = factions.getConfig();
  }
}
