package me.ep.extraapi.api.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class GuiUtils{
		
	private Inventory inv;
	private String name;
	private int size;	
	private InventoryHolder holder = null;
	
	public GuiUtils(String name, int size, InventoryHolder holder){
		this.name = name;
		this.size = size;
		this.holder = holder;
		this.inv = Bukkit.createInventory(this.holder, this.size, this.name.replace("&", "§"));				
	}
	
	public String getName(){
		return this.name;
	}
	
	public InventoryHolder getHolder(){
		return this.holder;
	}
	
	public void setItem(int slot, ItemStack item){
		this.getInventory().setItem(slot, item);		
	}
	
	public void addItem(ItemStack item){
		this.getInventory().addItem(item);
	}
	
	private Inventory getInventory(){
		return this.inv;
	}
	
	public boolean containsItem(ItemStack item, int slot){
		if (this.getInventory().contains(item, slot)){
			return true;			
		}
		return false;
	}
	
	public void openInv(Player p){
		p.openInventory(this.getInventory());		
	}

}
