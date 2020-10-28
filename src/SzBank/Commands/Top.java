package SzBank.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import SzBank.GUIs.TopGUI;

public class Top implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
		Player p = (Player)sender;
		
			if(command.getName().equalsIgnoreCase("top")) {
				
				TopGUI.openTop(p);
				
			}
		return false;
	}

}
