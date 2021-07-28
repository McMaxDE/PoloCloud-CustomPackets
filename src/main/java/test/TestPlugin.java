package test;

import de.polocloud.api.gameserver.IGameServer;
import de.polocloud.api.network.protocol.packet.PacketRegistry;
import de.polocloud.plugin.api.CloudExecutor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        PacketRegistry.registerPacket(1337, TestPacket.class);
        CloudExecutor.getInstance().registerPacketHandler(new TestPacketHandler());

        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void handle(PlayerJoinEvent event) {
        CloudExecutor.getInstance().getGameServerManager().getGameServers().thenAccept(servers -> {

            for (IGameServer server : servers) {
                server.sendPacket(new TestPacket(event.getPlayer().getName()));
            }

        });
    }


}
