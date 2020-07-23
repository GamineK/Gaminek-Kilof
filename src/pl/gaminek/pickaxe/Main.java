package pl.gaminek.pickaxe;

import org.bukkit.plugin.java.JavaPlugin;
import pl.gaminek.pickaxe.listeners.BlockBreakListener;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        registerEvents();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }
}
