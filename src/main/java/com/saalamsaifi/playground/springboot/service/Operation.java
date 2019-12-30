package com.saalamsaifi.playground.springboot.service;

public interface Operation {
	boolean handles(char op);

	int apply(int lhs, int rhs);
}
