package com.github.startzyp.minecraft;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class DeathDropLore extends JavaPlugin implements Listener {
    @EventHandler
    public void PlayerDeatheent(PlayerDeathEvent event){
        Player entity = event.getEntity();
        PlayerInventory inventory = entity.getInventory();
        for (int a=100;a<=103;a++){
            ItemStack item = inventory.getItem(a);
            if (item==null||item.getType()== Material.AIR){
                continue;
            }
            if (!item.hasItemMeta()){
                continue;
            }
            if (!item.getItemMeta().hasLore()){
                continue;
            }
            String s = item.getItemMeta().getLore().toString();
            if (s.contains(getConfig().getString("Lore"))){
                inventory.setItem(a,null);
                entity.getWorld().dropItemNaturally(entity.getLocation().add(0,2,0),item);
            }
        }
        for (int a=0;a<=35;a++){
            ItemStack item = inventory.getItem(a);
            if (item==null||item.getType()== Material.AIR){
                continue;
            }
            if (!item.hasItemMeta()){
                continue;
            }
            if (!item.getItemMeta().hasLore()){
                continue;
            }
            String s = item.getItemMeta().getLore().toString();
            if (s.contains(getConfig().getString("Lore"))){
                inventory.setItem(a,null);
                entity.getWorld().dropItemNaturally(entity.getLocation().add(0,2,0),item);
            }
        }
    }

    @Override
    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
        }
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        super.onEnable();
    }
}
