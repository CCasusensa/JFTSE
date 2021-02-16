package com.ft.emulator.server.game.core.matchplay.battle;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
@Setter
public class SkillCrystal {
    private short id;
    private short explicitSkillId;
    private Date timeSpawned;

    public SkillCrystal() {
        this.explicitSkillId = -1;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        this.setTimeSpawned(cal.getTime());
    }
}
