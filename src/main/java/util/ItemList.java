package util;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemList {

    public final static ItemStack air;
    public final static ItemStack x;
    public final static ItemStack black;

    public final static ItemStack right;

    public final static ItemStack y;
    public final static ItemStack n;

    static {
        air = new ItemStack(Material.AIR);
    }

    static {
        x = new ItemStack(Material.BARRIER);
        ItemMeta m = x.getItemMeta();
        m.setDisplayName("§cX");
        x.setItemMeta(m);
    }

    static {
        black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta m = black.getItemMeta();
        m.setDisplayName(" ");
        black.setItemMeta(m);
    }

    static {
        right = new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA);
        ItemMeta m = right.getItemMeta();
        m.setDisplayName("§a→");
        right.setItemMeta(m);
    }

    static {
        y = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta m = y.getItemMeta();
        m.setDisplayName("§a네");
        y.setItemMeta(m);
    }

    static {
        n = new ItemStack(Material.RED_TERRACOTTA);
        ItemMeta m = n.getItemMeta();
        m.setDisplayName("§c아니요");
        n.setItemMeta(m);
    }

}
