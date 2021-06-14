package com.jftse.emulator.server.game.core.packet.packets.ranking;

import com.jftse.emulator.server.database.model.player.Player;
import com.jftse.emulator.server.database.model.player.PlayerStatistic;
import com.jftse.emulator.server.game.core.constants.GameMode;
import com.jftse.emulator.server.game.core.packet.PacketID;
import com.jftse.emulator.server.networking.packet.Packet;

import java.util.List;

public class S2CRankingDataAnswerPacket extends Packet {
    public S2CRankingDataAnswerPacket(char result, byte gameMode, int page, List<Player> playerList) {
        super(PacketID.S2CRankingDataAnswer);

        this.write(result);

        this.write(0); // unk
        this.write((byte) 0); // unk
        this.write(gameMode);

        this.write((byte) playerList.size());

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            PlayerStatistic playerStatistic = player.getPlayerStatistic();

            int ranking = (page == 1 ? 0 : (page * 10) - 10) + 1 + i;
            this.write(ranking); // ranking
            this.write((byte) 0); // unknown / not used
            this.write(Math.toIntExact(player.getId()));
            this.write(player.getName());
            this.write(player.getLevel());
            this.write(player.getExpPoints());

            if (gameMode == GameMode.BASIC) {
                this.write(playerStatistic.getBasicRecordWin());
                this.write(playerStatistic.getBasicRecordLoss());
                this.write(playerStatistic.getBasicRP());
            } else if (gameMode == GameMode.BATTLE) {
                this.write(playerStatistic.getBattleRecordWin());
                this.write(playerStatistic.getBattleRecordLoss());
                this.write(playerStatistic.getBattleRP());
            } else {
                this.write(playerStatistic.getGuardianRecordWin());
                this.write(playerStatistic.getGuardianRecordLoss());
                this.write(playerStatistic.getGuardianRP());
            }
        }
    }
}
