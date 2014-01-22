package me.planetm.Endernounce;
 
import java.util.ArrayList;
import java.util.logging.Logger;
 
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Endernounce extends JavaPlugin
{
	
	private static final Logger log = Logger.getLogger("Minecraft");
	private final EndernounceListener enderListener = new EndernounceListener(this);
	public final ArrayList<Player> EndernounceUsers = new ArrayList<Player>();
	
	@Override
	public void onEnable()
	{
		log.info("[Endernounce] Endernounce is now enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, enderListener, Event.Priority.Normal, this);
	}
	
	@Override
	public void onDisable()
	{
		log.info("[Endernounce] Endernounce is now disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("Endernounce"))
		    toggleEndernounce(sender);
		
		return true;
		
	}
	
	private void toggleEndernounce(CommandSender sender)
	{
		if ( !enabled((Player) sender) )
		{
		     EndernounceUsers.add((Player) sender);
		     ((Player)sender).sendMessage("[Endernounce] Endernounce is now enabled!");
		}
	}
	
}
