package SzBank;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import SzBank.Commands.Banco;
import SzBank.Commands.Top;
import SzBank.DataBases.PlayersDB;
import SzBank.Events.RegisterPlayer;
import SzBank.GUIs.BancoGUI;
import SzBank.GUIs.TopGUI;
import SzBank.Investors.Bitcoin;
import SzBank.Investors.MessageBuilder;
import SzBank.Investors.TopBuilder;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener{
	
	private File f = null;
	private FileConfiguration file = null;	

	public static Main m;
	public static Economy economy;
	
	Bitcoin btc;
	MessageBuilder msg;
	TopBuilder tops;
	
	@Override
	public void onEnable() {
	
		//Extra
		int tempo = Main.getPlugin().getConfig().getInt("Bolsa.Timer");
		
		//Enable Message
		Bukkit.getConsoleSender().sendMessage("§aSzBank iniciado com Sucesso!");
		
		//Config's Setup
		saveDefaultConfig();
		File fv = new File(getDataFolder(), "valores.yml");
		if(!fv.exists()) {
			saveResource("valores.yml", false);
		}
		
		//DataBase's Setup
		PlayersDB.create();
		PlayersDB.SaveConfig();
		
		//Register's
		registerCommands();
		registerEvents();
		
		//Economy Setup
		setupEconomy();
		
		//Scheduler's
		btc = new Bitcoin(this);
		btc.runTaskTimer(this, 60*20, tempo*20);
		
		msg = new MessageBuilder(this);
		msg.runTaskTimer(this, 60*20, (5+tempo)*20);
		
		tops = new TopBuilder(this);
		tops.runTaskTimer(this, 0, 60*20);	
		
		
	}
	
	@Override
	public void onDisable() {
		
		//Disable Message
		Bukkit.getConsoleSender().sendMessage("§cSzBank desativado com Sucesso!");
		
	}
	
	//Register Commands
	public void registerCommands() {
		getCommand("banco").setExecutor(new Banco());
		getCommand("top").setExecutor(new Top());
	}
	
	//Register Events
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new RegisterPlayer(), this);
		getServer().getPluginManager().registerEvents(new BancoGUI(), this);
		getServer().getPluginManager().registerEvents(new TopGUI(), this);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	//Instance Main
	public static Main getPlugin() {
		return Main.getPlugin(Main.class);
	}
	
	//Format's
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static String format(final double valor) {
		final NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
		format.setMaximumFractionDigits(2);
		return format.format(valor);
	}
	
	//Setup Economy
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
			return true;
		} else {
			return false;
		}
	}
	
	//Config valores.yml
	//Get
		public FileConfiguration getValores() {
			if(this.file == null) {
				this.f = new File(getDataFolder(), "valores.yml");
				this.file = YamlConfiguration.loadConfiguration(this.f);
			}
			return this.file;
		}
		
		//Save
		public void saveValores() {
			try {
				getValores().save(this.f);
			} catch (Exception e) {
				Bukkit.getConsoleSender().sendMessage("erro ao salvar: valores");
			}
		}
		
		//Reload
		public void reloadValores() {
			if(this.file == null) {
				this.f = new File(getDataFolder(), "valores.yml");
			}
			
			this.file = YamlConfiguration.loadConfiguration(this.f);
			
			if(this.file != null) {
				YamlConfiguration defaults = YamlConfiguration.loadConfiguration(this.f);
				this.file.setDefaults(defaults);
			}
			
		}
		
}