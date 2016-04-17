import java.util.*;

public class FriendlyFitness 
{
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("Please enter your age in years.");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please enter your height in inches.");
		double heightIn = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Please enter your weight in pounds.");
		double weightLbs = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Please enter the gender/sex you were assigned at birth (m or f).");
		String gender = sc.nextString();
		sc.nextLine();
		
		
		
	}
	
	private static double calculateBMR(int age, double heightIn, double weightLbs, String gender)
	{
		double bmr;
		if (gender.equals("m"))
		{
			bmr = 66 + (6.23 * weightLbs) + (12.7 * heightIn) - (6.8 * age);
		}
		else // female
		{
			bmr = 655 + (4.35 * weightLbs) + (4.7 * heightIn) - (4.7 * age);
		}

		return bmr;
	}
	
	private static double calculateTimeForCalBurn(int calToBurn, double bmr, double met)
	{
		double timeHrs = calToBurn / (bmr * met / 24);
		return timeHrs;
	}

}
