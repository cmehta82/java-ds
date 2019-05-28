package com.practice.java.ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicStackTest {

    private BasicStack<String> basicStack = new BasicStack<String>(10);

    @Test
    void testPushAndPop() {
        assertTrue(basicStack.push("1"));
        assertTrue(basicStack.push("2"));
        assertTrue(basicStack.push("3"));
        assertTrue(basicStack.push("4"));
        assertTrue(basicStack.push("5"));
        assertTrue(basicStack.push("6"));
        assertTrue(basicStack.push("7"));
        assertTrue(basicStack.push("8"));
        assertTrue(basicStack.push("9"));
        assertTrue(basicStack.push("10"));
        assertFalse(basicStack.push("11"));

        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNotNull(basicStack.pop());
        assertNull(basicStack.pop());
    }
}