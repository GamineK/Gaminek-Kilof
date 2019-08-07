package kodicrew.gaminek.kilof.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;





public final class ChatUtil
{
  public static String iiIi;
  public static String nmsver = Bukkit.getServer().getClass().getPackage().getName(); static  {
    nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
  }
  
  public static void sendTitleMessage(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
    if (title == null) {
      title = "";
    }
    if (subtitle == null) {
      subtitle = "";
    }
    title = title.replace("&", "§");
    subtitle = subtitle.replace("&", "§");
    CraftPlayer craftPlayer = (CraftPlayer)player;
    PacketPlayOutTitle packetTimes = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
    (craftPlayer.getHandle()).playerConnection.sendPacket(packetTimes);
    IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
    PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
    (craftPlayer.getHandle()).playerConnection.sendPacket(packetTitle);
    IChatBaseComponent chatSubtitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
    PacketPlayOutTitle packetSubtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubtitle);
    (craftPlayer.getHandle()).playerConnection.sendPacket(packetSubtitle);
  }
  
  public static String fixColor(String text) { return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»").replace("<<", "«")); }

  
  public static void sendMessage(Player p, String text) { p.sendMessage(fixColor(text)); }
}
