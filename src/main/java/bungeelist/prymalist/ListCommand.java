package bungeelist.prymalist;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Map;


public class ListCommand extends Command {

    public ListCommand(){
        super("list");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {


		Map<String, ServerInfo> test = ProxyServer.getInstance().getServersCopy();

             ProxyServer.getInstance().getConsole().sendMessage("Array:" + test);
             ProxyServer.getInstance().broadcast(String.valueOf
                     (ProxyServer.getInstance().getPlayers()));
             ProxyServer.getInstance().broadcast(String.valueOf
                (ProxyServer.getInstance().getPlayers().size()));
             ProxyServer.getInstance().broadcast(String.valueOf
                     (ProxyServer.getInstance().getServerInfo("dev").getPlayers()));
		ProxyServer.getInstance().broadcast(String.valueOf
			(ProxyServer.getInstance().getServerInfo("dev").getName()));

             ProxyServer.getInstance().broadcast(String.valueOf
                ((long) ProxyServer.getInstance().getServerInfo("dev").getPlayers().size()));;



    }
}
