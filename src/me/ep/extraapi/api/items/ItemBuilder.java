package me.ep.extraapi.api.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack itemStack;
	private ItemMeta itemMeta;
	
	public ItemBuilder(Material material, String nome, int quantidade, List<String> lore) {
		this.itemStack = new ItemStack(material);
		this.itemMeta = this.itemStack.getItemMeta();
		this.itemMeta.setDisplayName(nome.replace("&", "§"));
		this.itemMeta.setLore(lore);
		this.itemStack.setItemMeta(this.itemMeta);
	}
	
	public ItemStack toItemStack(){
		return this.itemStack;
	}
	
	public ItemMeta getItemMeta(){
		return this.itemMeta;
	}	

}
