package SzBank.Investors;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scheduler.BukkitRunnable;

import SzBank.Main;
import SzBank.DataBases.PlayersDB;

public class TopBuilder extends BukkitRunnable {

	public static Main m = Main.getPlugin();
	
	//BTC
	public static HashMap<String, Double> contas = new HashMap<>();
	public static List<Entry<String, Double>> valores;
	
	//ETH
	public static HashMap<String, Double> ethc = new HashMap<>();
	public static List<Entry<String, Double>> ethv;
	
	public static String top1p;
	public static Double top1v;
	
	Main plugin;
	public TopBuilder(Main plugin) {
		this.plugin = plugin;
	}
	
	
	public void run() {
		
		m.getServer().broadcastMessage("TOP ATUALIZADO!");
		atualizadorBitcoins();
		atualizadorEthereum();
		
	}
	
	public void atualizadorBitcoins() {
		
		for (OfflinePlayer offline : Bukkit.getOfflinePlayers()) {
			double bitcoins = PlayersDB.fc.getDouble(offline.getUniqueId() + ".Bitcoin");
			contas.put(offline.getName(), bitcoins);
		}
		
		Stream<Entry<String, Double>>  streamOrdenada = contas.entrySet().stream().sorted((x, y)-> y.getValue().compareTo(x.getValue()));
		valores = streamOrdenada.collect(Collectors.toList());
		
	}
	
	public void atualizadorEthereum() {
		
		for (OfflinePlayer offlinee : Bukkit.getOfflinePlayers()) {
			double ethereum = PlayersDB.fc.getDouble(offlinee.getUniqueId() + ".Ethereum");
			ethc.put(offlinee.getName(), ethereum);
		}
		
		Stream<Entry<String, Double>>  streamOrdenadae = ethc.entrySet().stream().sorted((x, y)-> y.getValue().compareTo(x.getValue()));
		ethv = streamOrdenadae.collect(Collectors.toList());
		
	}
	
}
