package SzBank.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import SzBank.Main;
import SzBank.DataBases.PlayersDB;

public class RegisterPlayer implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String nick = p.getDisplayName();
		
		if(!PlayersDB.fc.contains(String.valueOf(p.getUniqueId()))) {
			PlayersDB.fc.set(String.valueOf(p.getUniqueId()) + ".Nick", nick);
			PlayersDB.fc.set(String.valueOf(p.getUniqueId()) + ".Registrado", 0);
			PlayersDB.fc.set(String.valueOf(p.getUniqueId() + ".Bitcoin"), 0.0);
			PlayersDB.fc.set(String.valueOf(p.getUniqueId() + ".Ethereum"), 0.0);
			PlayersDB.fc.set(String.valueOf(p.getUniqueId() + ".Stellar"), 0.0);
			
			if(Main.getPlugin().getConfig().getBoolean("Logs.RegisterPlayer") == true) {
				
				Bukkit.getConsoleSender().sendMessage("§aSzBank: "+nick+" Registrado com Sucesso!");
				
			} else {
				
			}
			
			PlayersDB.SaveConfig();
			
		}
	}
	
}
