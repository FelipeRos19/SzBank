package SzBank.GUIs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import SzBank.Main;
import SzBank.APIs.ActionBar;
import SzBank.APIs.MoneyFormat;
import SzBank.APIs.Requests;
import SzBank.APIs.SkullCreator;
import SzBank.DataBases.PlayersDB;

public class BancoGUI implements Listener{

	//Main
	public static Main m = Main.getPlugin();
	
	//Icons
	public static ItemStack open;
	public static ItemMeta openmeta;
	public static ItemStack top;
	public static ItemMeta topmeta;
	
	//Infos
	public static double value = m.getConfig().getDouble("Banco.Iniciar");
	public static String nome = m.getConfig().getString("Banco.Nome").replace("&", "§");
	public static String valorf = MoneyFormat.format(value);
	
	@EventHandler
	public void click(InventoryClickEvent e) {
		if((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			Player p = (Player) e.getWhoClicked();
			
			if(inv.getTitle().equals(m.getConfig().getString("Banco.Nome").replace("&", "§"))) {
				e.setCancelled(true);
				
				if(e.getCurrentItem().isSimilar(open)) {
					
					if(Main.economy.getBalance(p) >= value) {
						
						Main.economy.withdrawPlayer(p, value);
						PlayersDB.fc.set(p.getUniqueId() + ".Registrado", 1);
						PlayersDB.SaveConfig();
						
						ActionBar msg = new ActionBar("§aParabéns você acaba de abrir sua conta!");
						msg.sendToPlayer(p);
						p.closeInventory();
						
					} else {
						
						ActionBar msg = new ActionBar("§cVocê não possui Dinheiro suficiente!");
						msg.sendToPlayer(p);
						p.closeInventory();
						
					}
					
				}
				
				if(e.getCurrentItem().isSimilar(top)) {
					TopGUI.openTop(p);
				}
			}
		}
	}
	
	public static void openBanco(Player p) {
		Inventory banco = Bukkit.createInventory(null, 4*9, m.getConfig().getString("Banco.Nome").replace("&", "§"));
		
		String saldo = MoneyFormat.format(Requests.getSaldo(p));
		String bsaldo = MoneyFormat.format(Requests.getBitcoin(p));
		String esaldo = MoneyFormat.format(Requests.getEthereum(p));
		String ssaldo = MoneyFormat.format(Requests.getStellar(p));
		
		//Icon de abrir conta
		open = SkullCreator.Green;
		openmeta = open.getItemMeta();
		openmeta.setDisplayName("§aIniciar conta no Banco");
		List<String> openlore = new ArrayList<String>();
		openlore.add("");
		openlore.add("§7Bem-Vindo ao "+nome);
		openlore.add("");
		openlore.add("§7Vejo que você não possui uma conta.");
		openlore.add("§7Pra registrar-se você precisa de todos os Requisitos.");
		openlore.add("§7Aqui está a Lista.");
		openlore.add("");
		openlore.add("§7  * "+valorf+"§2 $");
		openlore.add("");
		openlore.add("§aCaso você tenha os requisitos basta Clicar no ícone!");
		openmeta.setLore(openlore);
		open.setItemMeta(openmeta);
		
		//Icon Perfil
		ItemStack player = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta playermeta = (SkullMeta) player.getItemMeta();
		playermeta.setOwner(p.getDisplayName());
		playermeta.setDisplayName("§6§lPerfil");
		List<String> playerlore = new ArrayList<String>();
		//Lore
		playerlore.add("");
		playerlore.add("§7Nome: §6"+p.getDisplayName()+"§7.");
		playerlore.add("§7Money: "+saldo+" §2$§7.");
		playerlore.add("§7Bitcoins: "+bsaldo+" §2BTC§7.");
		playerlore.add("§7Ethereum: "+esaldo+" §2ETH§7.");
		playerlore.add("§7Stellar: "+ssaldo+" §2XLM§7.");
		playerlore.add("");
		playermeta.setLore(playerlore);
		player.setItemMeta(playermeta);
		
		//Icon Top
		top = SkullCreator.Money;
		topmeta = top.getItemMeta();
		topmeta.setDisplayName("§aTop Moedas");
		List<String> toplore = new ArrayList<String>();
		toplore.add("");
		toplore.add("§7Ao clicar você será redirecionado ao");
		toplore.add("§7Top Moedas de nosso §aBanco§7!");
		toplore.add("");
		topmeta.setLore(toplore);
		top.setItemMeta(topmeta);
		
		//Set Icons
		if(Requests.getRegister(p) == 0) {
			
			banco.setItem(13, open);
			
		} else {
			
			banco.setItem(31, player);
			banco.setItem(11, top);
			
		}
		
		
		p.openInventory(banco);
	}
	
}
