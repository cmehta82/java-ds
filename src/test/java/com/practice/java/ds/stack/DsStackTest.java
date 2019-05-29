package com.practice.java.ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DsStackTest {

    private DsStack<String> dsStack = new DsStack<>(10);

    @Test
    void testPushAndPop() {
        assertTrue(dsStack.push("1"));
        assertTrue(dsStack.push("2"));
        assertTrue(dsStack.push("3"));
        assertTrue(dsStack.push("4"));
        assertTrue(dsStack.push("5"));
        assertTrue(dsStack.push("6"));
        assertTrue(dsStack.push("7"));
        assertTrue(dsStack.push("8"));
        assertTrue(dsStack.push("9"));
        assertTrue(dsStack.push("10"));
        assertFalse(dsStack.push("11"));

        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNotNull(dsStack.pop());
        assertNull(dsStack.pop());
    }
}