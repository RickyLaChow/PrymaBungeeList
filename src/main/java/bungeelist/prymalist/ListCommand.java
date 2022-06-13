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
            String[] Culetto = ProxyServer.getInstance().getServersCopy().keySet().toArray(new String[0]);
            System.out.println("Informazioni giocatori servers:");
             for (int i = 0; i < ProxyServer.getInstance().getServersCopy().keySet().size(); i++) {
                System.out.println(Culetto[i] + ": " +
                        String.valueOf(ProxyServer.getInstance().getServerInfo(Culetto[i]).getPlayers().size()));
                System.out.println("Lista Giocatori " + Culetto[i] + " " +
                        String.valueOf(ProxyServer.getInstance().getServerInfo(Culetto[i]).getPlayers()));
             }
    }
}
