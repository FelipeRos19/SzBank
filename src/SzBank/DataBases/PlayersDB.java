package SzBank.DataBases;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import SzBank.Main;


public class PlayersDB {
	
	static File f;
	public static FileConfiguration fc;
	static PlayersDB m;

	public static void create() {
		f = new File(Main.getPlugin().getDataFolder() + "/databases/Players.db");
		fc = YamlConfiguration.loadConfiguration(f);
	}

	public static void SaveConfig() {
		try {
			fc.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PlayersDB config() {
		return m;
	}
}
