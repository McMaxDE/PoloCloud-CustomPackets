package test;

import de.polocloud.api.network.protocol.packet.Packet;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class TestPacket extends Packet {

    private String username;

    public TestPacket(){

    }

    public TestPacket(String username) {
        this.username = username;
    }

    @Override
    public void write(ByteBuf byteBuf) throws IOException {
        writeString(byteBuf, username);
    }

    @Override
    public void read(ByteBuf byteBuf) throws IOException {
        username = readString(byteBuf);
    }

    public String getUsername() {
        return username;
    }
}
