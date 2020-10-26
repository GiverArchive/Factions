package me.giverplay.factions;

import me.giverplay.factions.command.commands.AreaCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Factions extends JavaPlugin
{
  private static Factions instance;
  
  @Override
  public void onEnable()
  {
    getLogger().info("Inicializando...");
    
    instance = this;
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
  
  public static Factions getInstance()
  {
    return instance;
  }
}
