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

	return true; 
	}
	
	private @NotNull ItemStack createItemStack() {
		
		
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);

		// Thêm enchantment
		item.addEnchantment(Enchantment.DIG_SPEED, 5);

		ItemMeta meta = item.getItemMeta();

		// Thêm tên
		// Video về Component: https://youtu.be/EXEI-fjNse0
		Component name = Component.text("&cCustom&6Items");
		meta.displayName(name);

		// Thêm chú thích
		List<Component> lore = new ArrayList<>();
		lore.add(Component.newline());
		lore.add(Component.text(addColor("Đây là dòng thứ 1")));
		lore.add(Component.newline());
		lore.add(Component.text(addColor("Đây là dòng thứ 2")));

		item.setItemMeta(meta);

		return item;
	}

	// Video hướng dẫn tại https://youtu.be/oBBl4Wp522I
	private @NonNull String addColor(@NonNull String a){
		return ChatColor.translateAlternateColorCodes('&', a);
	}
}
