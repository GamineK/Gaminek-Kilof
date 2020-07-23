package pl.gaminek.pickaxe.listeners;

import pl.gaminek.pickaxe.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onMine(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack s = e.getPlayer().getItemInHand();
        if (s.getType().equals(Material.DIAMOND_PICKAXE) && s.getDurability() == 1559) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 100));
            ChatUtil.sendMessage(p, "&CTwoj kilof ma jedno uzycie, napraw go :)");
            ChatUtil.sendTitle(p, "&cKILOF", "&eTwoj kilof ma jedno uzycie! Idz go napraw!", 5, 60, 5);
            e.setCancelled(true);
            s.setDurability((short)1559);
        }
    }
}
