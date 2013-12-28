package me.ksmit799197.gge;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[Greek God Essentials]" + pdfFile.getName() + " v" + pdfFile.getVersion() + " Has Been Disabled!");
		saveConfig();
	}

	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[Greek God Essentials] " + pdfFile.getName() + " v" + pdfFile.getVersion() + " Has Been Enabled!");
		saveConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
		if(sender instanceof Player){
			Player player = (Player) sender;

			//Commands

			if(commandLabel.equalsIgnoreCase("setwp")){
				if(player.isOp() || player.hasPermission("gge.setwp")){
					getConfig().set(player.getName() + ".x", player.getLocation().getBlockX());
					getConfig().set(player.getName() + ".y", player.getLocation().getBlockY());
					getConfig().set(player.getName() + ".z", player.getLocation().getBlockZ());
					saveConfig();
					player.sendMessage(ChatColor.GREEN + "[GGE] The god's have taken notice of your personal waypoint!");}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("tpwp")){
				if(player.isOp() || player.hasPermission("gge.tpwp")){
					int x = getConfig().getInt(player.getName() + ".x"), y = getConfig().getInt(player.getName() + ".y"), z = getConfig().getInt(player.getName() + ".z");
					player.teleport(new Location(player.getWorld(), x, y, z));
					player.sendMessage(ChatColor.GREEN + "[GGE] The god's have teleported you to your personal waypoint!");
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("ggeinfo")){
				if(player.isOp() || player.hasPermission("gge.info")){
					PluginDescriptionFile pdfFile = this.getDescription();
					player.sendMessage(ChatColor.GREEN + "[GGE] You're currently running Greek God Essentials v" + pdfFile.getVersion());
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("feed")){
				if(player.isOp() || player.hasPermission("gge.feed")){
					if(args.length == 0){
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.GREEN + "[GGE] The gods have banished your hunger!");	
						}
					else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							targetPlayer.setFoodLevel(20);
							player.sendMessage(ChatColor.GREEN + "[GGE] Set Hunger to 20!");
							targetPlayer.sendMessage(ChatColor.GREEN + "[GGE] The gods have banished your hunger!");
						}
						else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
							}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
					}
			}
			else if(commandLabel.equalsIgnoreCase("heal")){
				if(player.isOp() || player.hasPermission("gge.heal")){
					if(args.length == 0){
						player.setHealth(20.0);
						player.setFireTicks(0);
						player.sendMessage(ChatColor.GREEN + "[GGE] You Have Been Healed by the Gods!");
					}else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							targetPlayer.setHealth(20.0);
							targetPlayer.setFireTicks(0);
							targetPlayer.sendMessage(ChatColor.GREEN + " [GGE] You Have Been Healed by the Gods!");
						}else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
						}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("starve")){
				if(player.isOp() || player.hasPermission("gge.starve")){
					if(args.length == 0){
						player.setFoodLevel(0);
						player.sendMessage(ChatColor.GREEN + "[GGE] The Gods have Starved you!");	
					}
					else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							targetPlayer.setFoodLevel(0);
							player.sendMessage(ChatColor.GREEN + "[GGE] Set Player's Food to 0!");
							targetPlayer.sendMessage(ChatColor.GREEN + "[GGE] The Gods have Starved you!");
						}else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
						}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("ignite")){
				if(player.isOp() || player.hasPermission("gge.ignite")){
					if(args.length == 0){
						player.setFireTicks(500);
						player.sendMessage(ChatColor.GREEN + "[GGE] The Gods have set you on fire!");	
					}
					else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							targetPlayer.setFireTicks(500);
							targetPlayer.sendMessage(ChatColor.GREEN + "[GGE] The Gods have set you on fire!");
							player.sendMessage(ChatColor.GREEN + "[GGE] Set Player On Fire!");
						}else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
						}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("slap")){
				if(player.isOp() || player.hasPermission("gge.slap")){
					if(args.length == 0){
						player.damage(1.0);
						player.sendMessage(ChatColor.GREEN + "[GGE] The Gods have slapped you!");	
					}
					else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							player.damage(1.0);
							targetPlayer.sendMessage(ChatColor.GREEN + "[GGE] The Gods have slapped you!");
							player.sendMessage(ChatColor.GREEN + "[GGE] Slapped Player!");
						}else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
						}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("kill")){
				if(player.isOp() || player.hasPermission("gge.kill")){
					if(args.length == 0){
						player.damage(20.0);
						player.sendMessage(ChatColor.GREEN + "[GGE] The Gods have killed you!");	
					}
					else if(args.length == 1){
						if(player.getServer().getPlayer(args [0])!=null){
							Player targetPlayer = player.getServer().getPlayer(args [0]);
							targetPlayer.damage(20.0);
							targetPlayer.sendMessage(ChatColor.GREEN + "[GGE] The Gods hae killed you!");
							player.sendMessage(ChatColor.GREEN + "[GGE] Killed Player!");
						}else{
							player.sendMessage(ChatColor.RED + "[ERROR] Sorry but the Gods cant seem to find that player!");
						}
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "[ERROR] You don't have permission to do this!");
				}
			}
			else if(commandLabel.equalsIgnoreCase("fireball")){
				if(player.isOp() || player.hasPermission("gge.fireball")){
					
				}
				else{
					player.sendMessage(ChatColor.RED + "[GGE    ERROR] You don't have permission to do this!");
				}
			}
		}return false;
	}
}