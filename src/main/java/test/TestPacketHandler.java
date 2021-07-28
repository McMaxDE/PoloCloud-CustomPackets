package test;

import de.polocloud.api.network.protocol.IPacketHandler;
import de.polocloud.api.network.protocol.packet.Packet;
import io.netty.channel.ChannelHandlerContext;
import org.bukkit.Bukkit;

public class TestPacketHandler extends IPacketHandler<Packet> {
    @Override
    public void handlePacket(ChannelHandlerContext channelHandlerContext, Packet obj) {

        TestPacket packet = (TestPacket) obj;

        Bukkit.broadcastMessage("Player " + packet.getUsername() + " joined the network!");

    }

    @Override
    public Class<? extends Packet> getPacketClass() {
        return TestPacket.class;
    }
}
