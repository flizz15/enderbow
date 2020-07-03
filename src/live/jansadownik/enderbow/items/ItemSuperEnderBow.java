package live.jansadownik.enderbow.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemSuperEnderBow {
    ItemStack bow;

    public ItemSuperEnderBow() {
        bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RESET + "Teleportation II");

        bowMeta.setDisplayName(ChatColor.BOLD + "Super EnderBow");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 3, true);
        bowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bow.setItemMeta(bowMeta);
    }

    public ItemStack getSuperEnderBow() {
        return bow;
    }
}
