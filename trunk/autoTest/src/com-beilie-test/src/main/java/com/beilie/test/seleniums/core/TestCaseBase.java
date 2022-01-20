package com.beilie.test.seleniums.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCaseBase {
    protected static Engine engine;

    @org.junit.BeforeClass
    public static void init1() {
        engine = Engine.getInstance();
    }

    @org.junit.AfterClass
    public static void clear1() {
        engine.quit();
        engine = null;
    }

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

