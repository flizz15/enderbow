package live.jansadownik.enderbow.recipes;

import live.jansadownik.enderbow.items.ItemEnderBow;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class EnderBowRecipe {
    ShapedRecipe enderBowRecipe;

    public EnderBowRecipe() {
        ItemStack enderBow = new ItemEnderBow().getEnderBow();
        enderBowRecipe = new ShapedRecipe(enderBow);

        enderBowRecipe.shape("EEE", "EBE", "EEE");
        enderBowRecipe.setIngredient('E', Material.ENDER_PEARL);
        enderBowRecipe.setIngredient('B', Material.BOW);
    }

    public ShapedRecipe getEnderBowRecipe() {
        return enderBowRecipe;
    }
}
