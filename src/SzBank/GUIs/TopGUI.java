package SzBank.GUIs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import SzBank.Main;
import SzBank.APIs.MoneyFormat;
import SzBank.APIs.SkullCreator;
import SzBank.Investors.TopBuilder;

public class TopGUI implements Listener{
	
	public static Main m = Main.getPlugin();
	
	public static ItemStack bitcoin;
	public static ItemMeta bitcoinmeta;
	public static ItemStack ethereum;
	public static ItemMeta ethereummeta;
	
	@EventHandler
	public void click(InventoryClickEvent e) {
		if((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			//Player p = (Player) e.getWhoClicked();
			
			if(inv.getTitle().equals("§aJogadores com Mais Moedas")) {
				e.setCancelled(true);
			}
		}
	}
	
	public static void openTop(Player p) {
		Inventory top = Bukkit.createInventory(null, 9*3, "§aJogadores com Mais Moedas");
		
		//BitCoins
		bitcoin = SkullCreator.Bitcoin;
		bitcoinmeta = bitcoin.getItemMeta();
		bitcoinmeta.setDisplayName("§aTop Bitcoins");
		List<String> lorebtc = new ArrayList<>();
		String top1p = TopBuilder.valores.get(0).getKey();
		double top1v = TopBuilder.valores.get(0).getValue();
		String top2p = TopBuilder.valores.get(1).getKey();
		double top2v = TopBuilder.valores.get(1).getValue();
		String top3p = TopBuilder.valores.get(2).getKey();
		double top3v = TopBuilder.valores.get(2).getValue();
		
		lorebtc.add("");
		
		if(top1p.isEmpty() == true) {
			top1p = "§cNinguém";
			top1v = 0;
			lorebtc.add("§a1º §f"+top1p+" §7- §a$"+top1v);
		} else {
			String top1f = MoneyFormat.format(top1v);
			lorebtc.add("§a1º §f"+top1p+" §7- §a$"+top1f);
		}
		
		if(top2p.isEmpty() == true) {
			top2p = "§cNinguém";
			top2v = 0;
			lorebtc.add("§a2º §f"+top2p+" §7- §a$"+top2v);
		} else {
			String top2f = MoneyFormat.format(top2v);
			lorebtc.add("§a2º §f"+top2p+" §7- §a$"+top2f);
		}
		
		if(top3p.isEmpty() == true) {
			top3p = "§cNinguém";
			top3v = 0;
			lorebtc.add("§a3º §f"+top3p+" §7- §a$"+top3v);
		} else {
			String top3f = MoneyFormat.format(top3v);
			lorebtc.add("§a3º §f"+top3p+" §7- §a$"+top3f);
		}
		
		bitcoinmeta.setLore(lorebtc);
		bitcoin.setItemMeta(bitcoinmeta);
	
		//Ethereum
		ethereum = SkullCreator.Ethereum;
		ethereummeta = ethereum.getItemMeta();
		ethereummeta.setDisplayName("§aTop Ethereum");
		List<String> loreeth = new ArrayList<>();
		String top1pe = TopBuilder.ethv.get(0).getKey();
		double top1ve = TopBuilder.ethv.get(0).getValue();
		String top2pe = TopBuilder.ethv.get(1).getKey();
		double top2ve = TopBuilder.ethv.get(1).getValue();
		String top3pe = TopBuilder.ethv.get(2).getKey();
		double top3ve = TopBuilder.ethv.get(2).getValue();
		
		loreeth.add("");
		
		if(top1pe.isEmpty() == true) {
			top1pe = "§cNinguém";
			top1ve = 0;
			loreeth.add("§a1º §f"+top1pe+" §7- §a$"+top1ve);
		} else {
			String top1fe = MoneyFormat.format(top1v);
			loreeth.add("§a1º §f"+top1pe+" §7- §a$"+top1fe);
		}
		
		if(top2pe.isEmpty() == true) {
			top2pe = "§cNinguém";
			top2ve = 0;
			loreeth.add("§a1º §f"+top2pe+" §7- §a$"+top2ve);
		} else {
			String top2fe = MoneyFormat.format(top1v);
			loreeth.add("§a1º §f"+top2pe+" §7- §a$"+top2fe);
		}
		
		if(top3pe.isEmpty() == true) {
			top3pe = "§cNinguém";
			top3ve = 0;
			loreeth.add("§a3º §f"+top3pe+" §7- §a$"+top3ve);
		} else {
			String top3fe = MoneyFormat.format(top3v);
			loreeth.add("§a3º §f"+top3pe+" §7- §a$"+top3fe);
		}
		ethereummeta.setLore(loreeth);
		ethereum.setItemMeta(ethereummeta);
		
		top.setItem(11, bitcoin);
		top.setItem(13, ethereum);
		p.openInventory(top);
		
	}
	
}
