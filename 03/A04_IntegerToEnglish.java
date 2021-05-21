package realTest03;

public class A04_IntegerToEnglish {

	public static void main(String[] args) {
		A04_IntegerToEnglish a = new A04_IntegerToEnglish();
//		System.out.println(a.solve(998));
//		System.out.println(a.solve(1115));
		System.out.println(a.solve(33998));
	}

	String[] ten = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	String[] twenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen" };
	String[] hundred = new String[] { 
	"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety" };

	public String solve(int num) {
		if(num==0) return "Zero";
		return helper(num);
	}

	private String helper(int num) {

		String s = "";
		if(num <10)
			s = ten[num];
		else if(num <20)
			s = twenty[num-10]; //12
		else if(num <100)
			s = hundred[num/10] +" "+helper(num%10); //95
		else if(num <1000)
			s = helper(num / 100) + " Hundred " + helper(num % 100);
		else if (num < 1000000)
			s = helper(num / 1000) + " Thousand " + helper(num % 1000);
		else if (num < 1000000000)
			s = helper(num / 1000000) + " Million " + helper(num % 1000000);
		else
			s = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
		return s;
	}

}
