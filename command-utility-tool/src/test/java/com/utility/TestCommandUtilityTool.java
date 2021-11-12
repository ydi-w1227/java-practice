package com.utility;

import org.junit.jupiter.api.Test;

public class TestCommandUtilityTool {

    @Test
    public void RunCommandUtilityTool() {
        CommandUtilityTool cut = new CommandUtilityTool();
        cut.execProcess();
    }
}
