package brd1version1;

public class IPComponent {
	double principal, rateOfInterest;
	int noOfInstallmentsPerYear, periodInMonths;
	double monthlyInstallmentAmount;
	int count1 = 0,count2=0;

	public IPComponent(double principal, double rateOfInterest, int noOfInstallmentsPerYear, int periodInMonths, double monthlyInstallment) {
		this.principal = principal;	this.rateOfInterest = rateOfInterest;	this.noOfInstallmentsPerYear = noOfInstallmentsPerYear;	this.periodInMonths = periodInMonths;	this.monthlyInstallmentAmount = monthlyInstallment;
  }

	void component(int bc) {
			float[] interestComponent = new float[periodInMonths + 1];
			float[] principalComponent = new float[periodInMonths + 1];
			float[] outstandingPrincipal = new float[periodInMonths + 1];
			outstandingPrincipal[0] = (float) principal;
			for (int l = 0; l < periodInMonths; l++) {
				interestComponent[l] = (outstandingPrincipal[l]) * ((float) rateOfInterest) /12.0f;                 //((float)t*12.0f);        
				principalComponent[l] = ((float) monthlyInstallmentAmount - interestComponent[l]);
				if (l < periodInMonths) {
					outstandingPrincipal[l + 1] = outstandingPrincipal[l] - principalComponent[l];
					if (count1++ == 0&&bc==0)
						System.out.println("s.no          O/s   \t     I               P         Installment");
					if (bc == 0)
						System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (l + 1), outstandingPrincipal[l], interestComponent[l], principalComponent[l], monthlyInstallmentAmount);
				} else {
					outstandingPrincipal[periodInMonths] = outstandingPrincipal[l] - principalComponent[l];
				}

			}
			if (bc != 0) {
				int b1 = bc - 1;
				try {
					if (periodInMonths >= bc)

					{
						if (count2++ ==0)

							System.out.println("\ns.no          O/s   \t     I               P         Installment");
					}
					System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (b1), outstandingPrincipal[b1], interestComponent[b1], principalComponent[b1], monthlyInstallmentAmount);
				} catch (IndexOutOfBoundsException ex1) {
					System.out.printf(
							"You entered the tenure for \"%d months\" and trying to retrieve the break component for the month of \"%dth month\"!\n",
							periodInMonths, bc);
				}
			}

	}

}
