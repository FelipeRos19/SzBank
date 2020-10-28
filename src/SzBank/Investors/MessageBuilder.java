package SzBank.Investors;

import org.bukkit.Server;
import org.bukkit.scheduler.BukkitRunnable;

import SzBank.Main;
import SzBank.APIs.MoneyFormat;

public class MessageBuilder extends BukkitRunnable{

	public static Main m = Main.getPlugin();
	public static Server s = Main.getPlugin().getServer(); 
	
	Main plugin;
	public MessageBuilder(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		
		//Bitcoins
		double bv = m.getValores().getDouble("Bitcoins.Value");
		String bvf = MoneyFormat.format(bv); //Preço Formatado
		
		
		//Ethereum
		//double ev = m.getValores().getDouble("Ethereum.Value");
		//String evf = MoneyFormat.format(ev);
		
		s.broadcastMessage("§aAlteração na Bolsa de Valores");
		s.broadcastMessage("");
		s.broadcastMessage("§6Bitcoin: §7Novo Preço: §a"+bvf+"§2$");
		s.broadcastMessage("§6Ethereum: §7Novo Preço: §a120§2$");
		s.broadcastMessage("§6Stellar: §7Novo Preço: §a120§2$");
		s.broadcastMessage("");
		
		
	}

}
