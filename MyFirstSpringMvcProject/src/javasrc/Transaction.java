package javasrc;

public class Transaction {
	private double premiumAmount;
	private double rate;
	private double yearBand;

	private Account account;
	
	public Transaction() {
		
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getYearBand() {
		return yearBand;
	}

	public void setYearBand(double yearBand) {
		this.yearBand = yearBand;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	// Methods
	public double calculetedAmount(double amount) {
		if(yearBand >1 && yearBand<5) {
			double rate = 2.5;
			double calculetedAmount = premiumAmount * rate ;
			return calculetedAmount;
		}else {
			double calculetedAmount = premiumAmount * rate ;
			return calculetedAmount;
		}
		
		
	}
	

}
