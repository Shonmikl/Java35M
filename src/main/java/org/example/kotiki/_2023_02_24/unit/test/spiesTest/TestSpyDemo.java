package org.example.kotiki._2023_02_24.unit.test.spiesTest;//package javaProf.unit.mockito.test.spiesTest;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestSpyDemo {

	@Spy
	ArrayList<String> listSpy;

	@Test
	public void testSpyReturnsRealValues() {
		String str = "Test Spy";

		listSpy.add(str);

		verify(listSpy).add(str);
		assertEquals(1, listSpy.size());
	}
}