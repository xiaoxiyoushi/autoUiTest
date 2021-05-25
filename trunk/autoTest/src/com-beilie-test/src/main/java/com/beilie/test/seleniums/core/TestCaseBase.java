package com.beilie.test.seleniums.core;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestCaseBase {
    protected static Engine engine;

    @BeforeClass
    public static void init() {
        engine = Engine.getInstance();
    }

    @AfterClass
    public static void clear() {
        engine.quit();
        engine = null;
    }
}

