package test;

import de.polocloud.api.module.Module;
import de.polocloud.api.network.protocol.packet.PacketRegistry;

public class TestModule extends Module {
    @Override
    public void onLoad() {
        PacketRegistry.registerPacket(1337, TestPacket.class);
    }

    @Override
    public void onShutdown() {

    }
}
