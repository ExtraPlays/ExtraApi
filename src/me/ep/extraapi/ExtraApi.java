package me.ep.extraapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ExtraApi extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Ativado");
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Versao: " + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Autor: ExtraPlays");		
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Desativado");
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Versao: " + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("[ExtraApi] Autor: ExtraPlays");
	}

}
