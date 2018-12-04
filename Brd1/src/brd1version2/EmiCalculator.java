package brd1version2;

public class EmiCalculator {
	double calculateInstallment(double principal, double rateOfInterest, int periodInMonths, int noOfInstallmentsPerYear) {
		double monthlyInstallmentAmount;
		int totalNumberOfInstallments;
		rateOfInterest = rateOfInterest / 100;
		totalNumberOfInstallments = (periodInMonths * noOfInstallmentsPerYear) / 12;
		if (periodInMonths < 0) {
			System.out.println("Tenure can not be negative");
			System.exit(0);
		}
		if (totalNumberOfInstallments < (12 / noOfInstallmentsPerYear)) {
			System.out.println("Tenure is less than the period of first intallment");
			System.exit(0);
		}
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallmentsPerYear))
				/ (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallmentsPerYear), totalNumberOfInstallments));
		System.out.printf("Equated monthly installment is: %.2f ", monthlyInstallmentAmount);
		return monthlyInstallmentAmount;

	}

}
