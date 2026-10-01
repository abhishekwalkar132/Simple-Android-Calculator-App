package com.example.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorEngineTest {

    private CalculatorEngine engine;

    @Before
    public void setUp() {
        engine = new CalculatorEngine();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(5.0, engine.add(2.0, 3.0), 0.0001);
        assertEquals(-1.0, engine.add(-2.0, 1.0), 0.0001);
    }

    @Test
    public void subtraction_isCorrect() {
        assertEquals(1.0, engine.subtract(4.0, 3.0), 0.0001);
        assertEquals(-5.0, engine.subtract(-2.0, 3.0), 0.0001);
    }

    @Test
    public void multiplication_isCorrect() {
        assertEquals(12.0, engine.multiply(3.0, 4.0), 0.0001);
        assertEquals(0.0, engine.multiply(0.0, 100.0), 0.0001);
    }

    @Test
    public void division_isCorrect() {
        assertEquals(2.5, engine.divide(5.0, 2.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void division_byZero_throwsException() {
        engine.divide(5.0, 0.0);
    }

    @Test
    public void sqrt_isCorrect() {
        assertEquals(3.0, engine.sqrt(9.0), 0.0001);
        assertEquals(0.0, engine.sqrt(0.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sqrt_negative_throwsException() {
        engine.sqrt(-4.0);
    }

    @Test
    public void toggleSign_isCorrect() {
        assertEquals(-5.0, engine.toggleSign(5.0), 0.0001);
        assertEquals(5.0, engine.toggleSign(-5.0), 0.0001);
    }

    @Test
    public void memory_operations_areCorrect() {
        engine.memoryClear();
        assertEquals(0.0, engine.getMemory(), 0.0001);

        engine.memoryAdd(5.0);
        assertEquals(5.0, engine.memoryRecall(), 0.0001);

        engine.memoryAdd(3.0);
        assertEquals(8.0, engine.getMemory(), 0.0001);

        engine.memorySubtract(2.0);
        assertEquals(6.0, engine.memoryRecall(), 0.0001);
    }
}
