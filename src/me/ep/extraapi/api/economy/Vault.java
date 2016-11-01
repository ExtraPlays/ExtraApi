package me.ep.extraapi.api.economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class Vault {
	
	private Economy econ = null;
	
	public Vault() {}
	
	public boolean setupEconomy(){
		RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	    if (economyProvider != null) {
	    	econ = economyProvider.getProvider();
	    }
	    return (econ != null);
	}
	
	public Economy getEcon() {
		return this.econ;
	}

}
