package SzBank.APIs;

import java.lang.reflect.Field;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class SkullCreator {
	
public static ItemStack Voltar; 
public static ItemStack Green;
public static ItemStack Red;
public static ItemStack Info;
public static ItemStack Money;
public static ItemStack Bitcoin;
public static ItemStack Ethereum;
	
	static {
		 Voltar = getSkull("http://textures.minecraft.net/texture/bd69e06e5dadfd84e5f3d1c21063f2553b2fa945ee1d4d7152fdc5425bc12a9"); 
		 Green = getSkull("http://textures.minecraft.net/texture/a26ec7cd3b6ae249997137c1b94867c66e97499da071bf50adfd37034132fa03");
		 Red = getSkull("http://textures.minecraft.net/texture/52dd11da04252f76b6934bc26612f54f264f30eed74df89941209e191bebc0a2");
		 Info = getSkull("http://textures.minecraft.net/texture/46178ad51fd52b19d0a3888710bd92068e933252aac6b13c76e7e6ea5d3226");
		 Money = getSkull("http://textures.minecraft.net/texture/e36e94f6c34a35465fce4a90f2e25976389eb9709a12273574ff70fd4daa6852");
		 Bitcoin = getSkull("http://textures.minecraft.net/texture/667da379f51d85d74fdba39a164d3f5062ef2ffc0b3e04d339376773931a4e");
		 Ethereum = getSkull("http://textures.minecraft.net/texture/241415ba1edbe51ebc9097e8dba5261b81ff551855cb5bffc2183e3b928f");
	}

	public static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        if (url == null || url.isEmpty())
            return skull;
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(skullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }
}