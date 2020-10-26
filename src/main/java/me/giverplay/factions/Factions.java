package me.giverplay.factions;

import me.giverplay.factions.area.AreaManager;
import me.giverplay.factions.command.commands.AreaCommand;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Factions extends JavaPlugin
{
  private static Factions instance;
  
  private AreaManager areaManager;
  
  @Override
  public void onEnable()
  {
    getLogger().info("Inicializando...");
    
    instance = this;
    
    if(!registerHook())
    {
      getLogger().severe("SimpleClans não foi encontrado...");
      setEnabled(false);
      return;
    }
    
    registerCommands();
    
    getLogger().info("Inicializado com sucesso!");
  }
  
  @Override
  public void onDisable()
  {
    getLogger().info("Desabilitando...");
  
    Bukkit.getScheduler().cancelTasks(this);
    HandlerList.unregisterAll(this);
    
    getLogger().info("Desabilitado com sucesso!");
  }
  
  private void registerCommands()
  {
    new AreaCommand();
  }
  
  private boolean registerHook()
  {
    if(Bukkit.getPluginManager().getPlugin("SimpleClans") == null)
    {
      return false;
    }
    
    areaManager = new AreaManager(this, SimpleClans.getInstance());
    return true;
  }
  
  public AreaManager getAreaManager()
  {
    return areaManager;
  }
  
  public static Factions getInstance()
  {
    return instance;
  }
}
