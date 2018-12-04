package brd1version2;

import java.util.Scanner;

public class BreakEmiInterestPrincipalComponent {
	private Scanner sc;

	void getEMIComponent(double principal, double rateOfInterest, int periodInMonths, int noOfInstallmentsPerYear) {
		double monthlyInstallmentAmount;
		int totalNoOfInstallments;
		rateOfInterest = rateOfInterest / 100;
		totalNoOfInstallments = (periodInMonths * noOfInstallmentsPerYear) / 12;
		if (periodInMonths < 0) {
			System.out.println("Tenure can not be negative");
			System.exit(0);
		}
		if (totalNoOfInstallments < (12 / noOfInstallmentsPerYear)) {
			System.out.println("Tenure is less than the period of first intallment");
			System.exit(0);
		}
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallmentsPerYear))
				/ (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallmentsPerYear), totalNoOfInstallments));
		float[] interestComponent = new float[totalNoOfInstallments + 1];
		float[] principalComponent = new float[totalNoOfInstallments + 1];
		float[] outstandingPrincipal = new float[totalNoOfInstallments + 1];
		outstandingPrincipal[0] = (float) principal;
		System.out.println("Please enter the installment number for which break up is required:");
		sc = new Scanner(System.in);
		int breakUpNumber = sc.nextInt();
		if (breakUpNumber > totalNoOfInstallments) {
			System.out.printf("Total number of installments are only:%d.\nBreak up is asked for:%d",
					totalNoOfInstallments, breakUpNumber);
		}
		else if(breakUpNumber<0){
			System.out.println("The installment number for which you require principal and interest components can't be negative");
		} else {
			System.out.println("s.no          O/s   \t       I              P        Installment");
			for (int l = 0; l < totalNoOfInstallments; l++) {
				interestComponent[l] = (outstandingPrincipal[l]) * ((float) rateOfInterest) / 12.0f;
				principalComponent[l] = ((float) monthlyInstallmentAmount - interestComponent[l]);
				if (l < totalNoOfInstallments) {
					outstandingPrincipal[l + 1] = outstandingPrincipal[l] - principalComponent[l];
					if ((l + 1) == breakUpNumber) {
						System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (l + 1), outstandingPrincipal[l], interestComponent[l], principalComponent[l],
								monthlyInstallmentAmount);
						System.exit(0);
					}
				}
			}
		}
	}

}
