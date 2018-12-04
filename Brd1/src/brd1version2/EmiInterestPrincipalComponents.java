package brd1version2;
public class EmiInterestPrincipalComponents {
	void getAllEMIComponenets(double principal, double rateOfInterest, int periodInMonths, int noOfInstallmentsPerYear)
	{
		double monthlyInstallmentAmount;
		int totalNoOfInstallments;
		rateOfInterest=rateOfInterest/100;
		totalNoOfInstallments = (periodInMonths * noOfInstallmentsPerYear) / 12;
		if(totalNoOfInstallments<0)
		{
			System.out.println("Tenure can not be negative");
			System.exit(0);
		}	
		if(totalNoOfInstallments<(12/noOfInstallmentsPerYear))
		{
			System.out.println("Tenure is less than the period of first intallment");
			System.exit(0);
		}
		
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallmentsPerYear)) / (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallmentsPerYear), totalNoOfInstallments));
		float[] interestComponent = new float[totalNoOfInstallments + 1];
		float[] principalComponent = new float[totalNoOfInstallments + 1];
	    float[] outstandingPrincipal = new float[totalNoOfInstallments + 1];
	    outstandingPrincipal[0] = (float) principal;
		System.out.println("\ns.no          O/s   \t       I              P        Installment");
		for (int l = 0; l < totalNoOfInstallments; l++) {
			interestComponent[l] = (outstandingPrincipal[l]) * ((float) rateOfInterest) / 12.0f;
			principalComponent[l] = ((float) monthlyInstallmentAmount - interestComponent[l]);
			if (l < totalNoOfInstallments) 
			{
				outstandingPrincipal[l + 1] = outstandingPrincipal[l] - principalComponent[l];
				System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (l + 1), outstandingPrincipal[l], interestComponent[l], principalComponent[l], monthlyInstallmentAmount);
			}
	    }
     }
  }


