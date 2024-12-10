package com.example.demo;

public class TaxResponse {
    private int employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;
    
	public TaxResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxResponse(int employeeId, String firstName, String lastName, double yearlySalary, double taxAmount,
			double cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "TaxResponse [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
    
    
}