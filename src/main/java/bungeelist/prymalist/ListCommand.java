package bungeelist.prymalist;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class ListCommand extends Command {

    public ListCommand(){
        super("list");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
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
}
