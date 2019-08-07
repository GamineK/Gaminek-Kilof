package kodicrew.gaminek.kilof;

import kodicrew.gaminek.kilof.listeners.PlayerBlockInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  private static Main inst;
  
  public void onEnable() {
    registerEvents();
    getLogger().info("ENABLING");
    getInst();
  }
  
  private void registerEvents() { getServer().getPluginManager().registerEvents(new PlayerBlockInteractEvent(), this); }

  
  public void onDisable() { getLogger().info("DISABLING"); }

  
  public static Main getInst() { return inst; }
}
