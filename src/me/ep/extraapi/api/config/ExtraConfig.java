package me.ep.extraapi.api.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import me.ep.extraapi.ExtraApi;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ExtraConfig {
	
	private File arq;
	public ExtraApi m;
	private String configName;
	private FileConfiguration fileconfig;
	 
	public ExtraConfig(String file, ExtraApi m){
		this.m = m;
		this.arq = new File(m.getDataFolder(), file);
		this.fileconfig = YamlConfiguration.loadConfiguration(this.arq);				
		this.configName = file;
		if (m.getResource(arq.getName()) != null){
			 m.saveResource(arq.getName(), false);			 
		}else {
			try {
				arq.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		
	}	
	
	public FileConfiguration config(){
		this.fileconfig = YamlConfiguration.loadConfiguration(this.arq);
		return this.fileconfig;		
	}	
	
	public void save(){
		try {			
			fileconfig.save(this.arq);
		} catch (Exception e) {
			Bukkit.getConsoleSender().sendMessage("[ExtraConfig] Nao foi Possivel Salvar a " + this.configName);
			e.printStackTrace();
		}
	}

	public void reloadConfig(){
		this.arq = new File(m.getDataFolder(), this.configName);
		try {
			this.fileconfig.load(this.arq);
		} catch (FileNotFoundException e) {
			System.out.println("[ExtraConfig] Config nao Encontrada");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			System.out.println("[ExtraConfig] Configuracao invalida");
			e.printStackTrace();
		}
	}
}
