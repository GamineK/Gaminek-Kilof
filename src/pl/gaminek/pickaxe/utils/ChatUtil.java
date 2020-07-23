package pl.gaminek.pickaxe.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public final class ChatUtil {
    public static void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + colored(title) + "\"}"));
        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + colored(subTitle) + "\"}"));
        PacketPlayOutTitle lengthPacket = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
        CraftPlayer plr = (CraftPlayer) player;
        plr.getHandle().playerConnection.sendPacket(titlePacket);
        plr.getHandle().playerConnection.sendPacket(subtitlePacket);
        plr.getHandle().playerConnection.sendPacket(lengthPacket);
    }

    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«"));
    }

    public static void sendMessage(Player p, String text) {
        p.sendMessage(colored(text));
    }
}
