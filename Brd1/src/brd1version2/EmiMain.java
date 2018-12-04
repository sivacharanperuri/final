package brd1version2;

import java.util.Scanner;

public class EmiMain {

	private static Scanner scanner;

	public static void main(String[] args) {
		double principal = 0.0;
		double rateOfInterest = 0.0;// rate of interest
		int noOfInstallmentsPerYear = 0;// no of installments per year
		int periodInMonths = 0;// no of months|period
		EmiCalculator emiCalculator = new EmiCalculator();
		EmiInterestPrincipalComponents emiIpComponent = new EmiInterestPrincipalComponents();
		BreakEmiInterestPrincipalComponent breakEmiIpComponent = new BreakEmiInterestPrincipalComponent();
		scanner = new Scanner(System.in);
		System.out.println("Please enter the following details:\nLoan amount:");
		principal = scanner.nextDouble();
		System.out.println("Rate of interest in percentage:");
		rateOfInterest = scanner.nextDouble();
		System.out.println("Period or tenure of loan in months:");
		periodInMonths = scanner.nextInt();
		System.out.println("Enter the number of installments for year:");
		noOfInstallmentsPerYear = scanner.nextInt();
		emiCalculator.calculateInstallment(principal, rateOfInterest, periodInMonths, noOfInstallmentsPerYear);
		emiIpComponent.getAllEMIComponenets(principal, rateOfInterest, periodInMonths, noOfInstallmentsPerYear);
		breakEmiIpComponent.getEMIComponent(principal, rateOfInterest, periodInMonths, noOfInstallmentsPerYear);

	}

}
