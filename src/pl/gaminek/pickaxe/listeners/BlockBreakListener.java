package pl.gaminek.pickaxe.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.gaminek.pickaxe.utils.ChatUtil;

public class BlockBreakListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getPlayer().getItemInHand();
        if (itemStack.getType().equals(Material.DIAMOND_PICKAXE) && itemStack.getDurability() == 1559) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 100));
            ChatUtil.sendMessage(player, "&CTwoj kilof ma jedno uzycie, napraw go :)");
            ChatUtil.sendTitle(player, "&cKILOF", "&eTwoj kilof ma jedno uzycie! Idz go napraw!", 5, 60, 5);
            event.setCancelled(true);
            itemStack.setDurability((short)1559);
        }
    }
}