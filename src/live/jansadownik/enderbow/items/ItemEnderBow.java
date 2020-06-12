package live.jansadownik.enderbow.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemEnderBow {
    ItemStack bow;

    public ItemEnderBow() {
        bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.RESET + "Teleportation I");

        bowMeta.setDisplayName(ChatColor.BOLD + "EnderBow");
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 2, true);
        bowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bow.setItemMeta(bowMeta);
    }

    public ItemStack getEnderBow() {
        return bow;
    }
}
