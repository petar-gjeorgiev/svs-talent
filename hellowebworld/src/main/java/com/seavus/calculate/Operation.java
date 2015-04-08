package com.seavus.calculate;

public class Operation {

	private int operand1;

	private int operand2;

	private OperationType type;

	private int result;

	public int getOperand1() {
		return operand1;
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		if (type == OperationType.ADD) {
			return operand1 + " + " + operand2 + " = " + result;
		} else {
			return operand1 + " - " + operand2 + " = " + result;
		}
	}

}
