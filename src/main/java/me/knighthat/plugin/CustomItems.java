package me.knighthat.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.knighthat.commands.Commands;

public class CustomItems extends JavaPlugin
{
	
	@Override
	public void onEnable() { 
		
		getCommand("customitems").setExecutor(new Commands(this));
	}
}
