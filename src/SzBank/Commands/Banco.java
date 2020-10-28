package SzBank.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import SzBank.GUIs.BancoGUI;

public class Banco implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
		Player p = (Player)sender;
		
			if(command.getName().equalsIgnoreCase("banco")) {
				
				BancoGUI.openBanco(p);
				
			}
		
		return false;
	}
	
}
