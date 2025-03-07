public class Calculator{
    public double simpleInterestDealer(double principal, double rate, double years){
        return principal*(rate/100)*years;
    }
    public double compoundInterestDealer(double principal, double rate, String compoundingFrequency, int years) {
        double interest = 0;
        int n = 0;
        switch (compoundingFrequency.toLowerCase()) {
            case "annually":
                n = 1;
                break;
            case "semi-annually":
                n = 2;
                break;
            case "quarterly":
                n = 4;
                break;
            case "monthly":
                n = 12;
                break;
            case "daily":
                n = 365;
                break;
            default:
                throw new IllegalArgumentException("Invalid compounding frequency: " + compoundingFrequency);
        }
        double ratePerPeriod = rate / n;
        int totalPeriods = n * years;
        interest = principal * Math.pow(1 + ratePerPeriod, totalPeriods);
        return interest;
    }
}

