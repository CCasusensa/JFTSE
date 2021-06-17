package com.jftse.emulator.server.game.core.packet.packets.messaging;

import com.jftse.emulator.server.game.core.packet.PacketID;
import com.jftse.emulator.server.networking.packet.Packet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2CAddFriendResponsePacket extends Packet {
    public S2CAddFriendResponsePacket(short result) {
        super(PacketID.S2CAddFriendAnswer);

        this.write(result);
    }
}