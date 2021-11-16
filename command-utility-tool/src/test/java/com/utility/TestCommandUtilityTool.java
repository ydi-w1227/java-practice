package com.utility;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestCommandUtilityTool {

    @Test
    public void RunCommandUtilityTool() throws IOException {
        WordCounterCLIController cut = new WordCounterCLIController();
        cut.execProcess();
    }
}
