package pl.gaminek.pickaxe;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {}

    private void registerEvents() { getServer().getPluginManager().registerEvents(new PlayerBlockInteractEvent(), this); }
}
