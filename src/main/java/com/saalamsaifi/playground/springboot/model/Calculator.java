package com.saalamsaifi.playground.springboot.model;

import java.util.Collection;

import com.saalamsaifi.playground.springboot.service.Operation;

public class Calculator {
	private final Collection<Operation> operations;

	public Calculator(Collection<Operation> operations) {
		this.operations = operations;
	}

	public void calculate(int lhs, int rhs, char op) {
		for (Operation operation : operations) {
			if (operation.handles(op)) {
				int result = operation.apply(lhs, rhs);
				System.out.printf("%d %s %d = %d%n", lhs, op, rhs, result);
				return;
			}
		}
		throw new IllegalArgumentException("Unknown Operation: " + op);
	}
}
