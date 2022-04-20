package me.knighthat.commands;

import lombok.NonNull;
import me.knighthat.plugin.CustomItems;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Commands implements CommandExecutor
{

	private CustomItems plugin;

	public Commands(CustomItems plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) { 
		
		if(!(sender instanceof Player)) return true;
		Player player = (Player) sender;
		
		ItemStack item = createItemStack();
		
		player.getInventory().addItem(item);

		// Xóa phù phép
		new BukkitRunnable(){

			@Override
			public void run() {

				 ItemStack inHand = player.getInventory().getItemInMainHand();
				 inHand.removeEnchantment(Enchantment.DIG_SPEED);
			}
		}.runTaskLater(plugin, 20L);

	return true; 
	}
	
	private @NotNull ItemStack createItemStack() {
		
		
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

		// Thêm enchantment
		item.addEnchantment(Enchantment.DIG_SPEED, 5);

		return item;
	}
}
