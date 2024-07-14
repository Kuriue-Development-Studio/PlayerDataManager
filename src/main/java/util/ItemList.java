package util;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemList {

    public final static ItemStack air;
    public final static ItemStack x;

    static {
        air = new ItemStack(Material.AIR);
        x = new ItemStack(Material.BARRIER);
        ItemMeta m = x.getItemMeta();
        m.setDisplayName("§cX");
        x.setItemMeta(m);
    }

}
