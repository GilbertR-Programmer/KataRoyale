package com.kataroyale.app.models.enums;

import lombok.Getter;

@Getter
public enum Task {
    PICK_WINNER("PICK_WINNER"),
    CUT_LOSERS("CUT_LOSERS"),
    RESET_COMPETITORS("RESET_COMPETITORS");

    private final String taskName;

    private Task(String taskName) {
        this.taskName = taskName;
    }
}
