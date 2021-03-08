package polymorphism;

public class OverRiddingTest {

	public static void main(String[] args) {
		PNB pnb = new PNB();
		System.out.println("PNB ROI : " + pnb.GetRateOfInterest());
		SBI sbi = new SBI();
		System.out.println("SBI ROI : " + sbi.GetRateOfInterest());
		ICICI icici = new ICICI ();
		System.out.println("ICICI ROI : " + icici.GetRateOfInterest());
	}

}

class bank{
	public double GetRateOfInterest() {
		return 0;
	}
}
class PNB extends bank{
	public double GetRateOfInterest() {
		return 7.5;
	}
}

class SBI extends bank{
	public double GetRateOfInterest() {
		return 7;
	}
}

class ICICI extends bank{
	public double GetRateOfInterest() {
		return 8;
	}
}