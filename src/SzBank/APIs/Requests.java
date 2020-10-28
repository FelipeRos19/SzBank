package SzBank.APIs;

import org.bukkit.entity.Player;

import SzBank.Main;
import SzBank.DataBases.PlayersDB;

public class Requests {

	//Pegar Registro
	public static int getRegister(Player p) {
		return PlayersDB.fc.getInt(p.getUniqueId() + ".Registrado");
	}
	
	//Pegar Saldo Economy
	public static double getSaldo(Player p) {
		return Main.economy.getBalance(p);
	}
	
	//Pegar Saldo Bitcoin
	public static double getBitcoin(Player p) {
		return PlayersDB.fc.getDouble(p.getUniqueId() + ".Bitcoin");
	}
	
	//Pegar Saldo Ethereum
	public static double getEthereum(Player p) {
		return PlayersDB.fc.getDouble(p.getUniqueId() + ".Ethereum");
	}
	
	//Pegar Saldo Stella
	public static double getStellar(Player p) {
		return PlayersDB.fc.getDouble(p.getUniqueId() + ".Stellar");
	}
}
