package me.ep.extraapi.api.packets;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
	
	PacketPlayOutChat packet;	
	private String msg;
	
	public ActionBar(){}
	
	public void sendToPlayer(Player p, String msg){
		this.msg = msg;
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + this.msg + "\"}"), (byte) 2);
		this.packet = packet;
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(this.packet);		
	}
	
	public void sendToAllPlayers(String msg){
		this.msg = msg;
		for (Player on : Bukkit.getOnlinePlayers()){
			PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + this.msg + "\"}"), (byte) 2);
			this.packet = packet;
			((CraftPlayer)on).getHandle().playerConnection.sendPacket(packet);			
		}
	}

}
