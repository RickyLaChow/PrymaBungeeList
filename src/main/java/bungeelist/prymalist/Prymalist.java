package bungeelist.prymalist;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class Prymalist extends Plugin {

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ListCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
