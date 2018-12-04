package brd1version1;
import java.util.Scanner;
public class EmiMain {
	private static Scanner sc;

	static double installment(double principal, double rateOfInterest, int periodInMonths, int noOfInstallmentsPerYear) {
		double monthlyInstallmentAmount;
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallmentsPerYear)) / (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallmentsPerYear), periodInMonths));
		return monthlyInstallmentAmount;

	}

	public static void main(String[] args) {
		double principal=0.0;
		double rateOfInterest=0.0;// rate of interest
		int totalNoOfInstallments;// no of installments for the tenure
		int noOfInstallmentsPerYear;// no of installments per year
		int periodInMonths;// no of years|period
		double monthlyInstallmentAmount ;// installment amount
		int rec = 1, hi;
		sc = new Scanner(System.in);
		OUT: do {

			System.out.println("Please enter the following details:\nLoan amount:");
			principal = sc.nextDouble();
			System.out.println("Rate of interest in percent:");
			rateOfInterest = sc.nextDouble();
			System.out.println("Period or tenure of loan in months:");
			periodInMonths = sc.nextInt();
			for (; periodInMonths < 0;) {
				System.out.println("Months can't be negative right! Please enter positive number of months  ");
				periodInMonths = sc.nextInt();

			}
			rateOfInterest = rateOfInterest / 100;
			System.out.println("Enter the number of payments for year:");
			noOfInstallmentsPerYear = sc.nextInt();
			// t=12;
			totalNoOfInstallments = (periodInMonths * noOfInstallmentsPerYear) / 12;
			if (totalNoOfInstallments == 0) {
				System.out.printf("The installment for the given values is:%f\n", (principal + principal * rateOfInterest));
				// System.exit(0);
				continue OUT;
			}

			System.out.println(
					"Enter one among the following options:\n1.Calculate Installment for given conditions\n2.Want to know the principal component and interest component\n3.Installment for a given break up period:");
			hi = sc.nextInt();
			switch (hi) {
			case 1: {//
				monthlyInstallmentAmount = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear); // calculation emi
				System.out.println(monthlyInstallmentAmount);
				break;
			}
			case 2: {
				int bc = 0;
				double monthlyInstallment = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear);
				IPComponent ip = new IPComponent(principal, rateOfInterest, noOfInstallmentsPerYear, periodInMonths, monthlyInstallment);
				ip.component(bc);
				break;
			}
			case 3: {
				double x1 = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear);
				System.out.println("Enter the month for which break up is required");
				int bc = sc.nextInt();
				IPComponent ip = new IPComponent(principal, rateOfInterest, noOfInstallmentsPerYear, periodInMonths, x1);
				ip.component(bc);
				break;
			}
			}
			System.out.println("\nDo you want to calculate for some other loan parameter values:\n1.yes\n2.no");
			rec = sc.nextInt();
			System.out.flush();
		} while (rec == 1);

	}

}
