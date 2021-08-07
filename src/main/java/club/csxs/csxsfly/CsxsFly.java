package club.csxs.csxsfly;

import club.csxs.csxsfly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CsxsFly extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("fly").setExecutor(new FlyCommand());

    }


}
