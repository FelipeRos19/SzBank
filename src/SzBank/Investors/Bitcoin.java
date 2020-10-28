package SzBank.Investors;

import java.util.SplittableRandom;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import SzBank.Main;

public class Bitcoin extends BukkitRunnable{
	
	private static final SplittableRandom random = new SplittableRandom();
	public static Main m = Main.getPlugin();
	
	
	Main plugin;
	public Bitcoin(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		
		double value = m.getValores().getDouble("Bitcoins.Value");
		double minvalue = m.getValores().getDouble("Bitcoins.MinValue");
		double maxvalue = m.getValores().getDouble("Bitcoins.MaxValue");

		double newvalue = random.nextDouble(minvalue, maxvalue);
		
		//Aumentou
		if(newvalue > value) {
			
			double p = ((newvalue-value)/value)*100;
			m.getValores().set("Bitcoins.Porcent", p);
			m.getValores().set("Bitcoins.Status", "pos");
			m.getValores().set("Bitcoins.Value", newvalue);
			m.saveValores();
			m.reloadValores();
			
		}
		
		//Diminuiu
		if(newvalue < value) {
			
			double p = ((value-newvalue)/value)*100;
			m.getValores().set("Bitcoins.Porcent", p);
			m.getValores().set("Bitcoins.Status", "neg");
			m.getValores().set("Bitcoins.Value", newvalue);
			m.saveValores();
			m.reloadValores();
			
		}
		if (m.getConfig().getBoolean("Logs.AlteracaoBolsa") == true) {
			
			Bukkit.getConsoleSender().sendMessage("§6Alterado preço do Bitcoin!");
			
		} else {
			
		}
		
		
	}

}
