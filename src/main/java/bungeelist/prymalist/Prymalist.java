package bungeelist.prymalist;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


public final class Prymalist extends Plugin {

    private File file;
    private Configuration configuration;

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ListCommand());

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        file = new File(getDataFolder() + "/lang.yml");

        try {
            if (!file.exists()) {
                try (InputStream in = getResourceAsStream("lang.yml")) {
                    Files.copy(in, file.toPath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
