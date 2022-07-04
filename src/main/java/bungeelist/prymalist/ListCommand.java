package bungeelist.prymalist;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ListCommand extends Command {

    private File file;
    private Configuration configuration;
    public int pingTimeout = 500;
    public String test1;

    public ListCommand(){
        super("list");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/PrymaBungeeList/lang.yml");
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] Servers = ProxyServer.getInstance().getServersCopy().keySet().toArray(new String[0]);
        if (!(sender instanceof ProxiedPlayer)) {
            System.out.println(ChatColor.GREEN + "" + configuration.get("info-server"));
            for (int i = 0; i < ProxyServer.getInstance().getServersCopy().keySet().size(); i++){
                System.out.println(" ");
                System.out.println( ChatColor.AQUA + "" + Servers[i] + ": " +
                        String.valueOf(ProxyServer.getInstance().getServerInfo(Servers[i]).getPlayers().size() + " \n" + configuration.get("status") +
                                String.valueOf(isReachable((InetSocketAddress) ProxyServer.getInstance().getServerInfo(Servers[i]).getSocketAddress(), 500))));
                System.out.println(ChatColor.DARK_AQUA + String.valueOf(ProxyServer.getInstance().getServerInfo(Servers[i]).getPlayers()));
            }

            System.out.println(ChatColor.YELLOW + "" + configuration.get("total-players") + " " + ProxyServer.getInstance().getOnlineCount());
        }
        else {
            if (configuration.get("only-console") == "false") {
                ProxiedPlayer player = (ProxiedPlayer) sender;
                if (player.hasPermission("prymabungee.list")) {
                    player.sendMessage(ChatColor.GREEN + "" + configuration.get("info-server"));
                    for (int i = 0; i < ProxyServer.getInstance().getServersCopy().keySet().size(); i++) {
                        player.sendMessage(" ");
                        player.sendMessage(ChatColor.AQUA + "" + Servers[i] + ": " +
                                String.valueOf(ProxyServer.getInstance().getServerInfo(Servers[i]).getPlayers().size() +  " \n" + configuration.get("status") +
                                        String.valueOf(isReachable((InetSocketAddress) ProxyServer.getInstance().getServerInfo(Servers[i]).getSocketAddress(), 500))));
                        player.sendMessage(ChatColor.DARK_AQUA + String.valueOf(ProxyServer.getInstance().getServerInfo(Servers[i]).getPlayers()));

                    }
                } else {
                    player.sendMessage(ChatColor.RED + "" + configuration.get("permission"));
                }
            }
        }
    }

    private Object isReachable(InetSocketAddress address, int i) {
        Socket socket = new Socket();
        try {
            socket.connect(address, pingTimeout);
            socket.close();
            return (ChatColor.GREEN + "online");
        } catch(IOException ignored) {
        }
        return (ChatColor.RED + "offline");
    }
}
