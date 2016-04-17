import java.util.*;
import java.text.DecimalFormat;

public class FriendlyFitness 
{
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		DecimalFormat df = new DecimalFormat("0.0");

		String[] activities = {"Walking (3.0 mph)", "Jogging", "Running", "Swimming", "Yoga", "Weight lifting", "Biking"};
		double[] mets = {3.5, 7.0, 10.0, 8.0, 2.5, 6.0, 8.0};
		
		System.out.println("Please enter the number of calories you have consumed.");
		int calsToBurn = sc.nextInt();
		sc.nextLine();

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
		String gender = sc.nextLine();
		
		double bmr = calculateBMR(age, heightIn, weightLbs, gender);
		for (int i = 0; i < activities.length; i++)
		{
			double timeMin = calculateMinToBurn(calsToBurn, bmr, mets[i]);
			System.out.println(activities[i] + ": " + df.format(timeMin) + "mins");
		}
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
	
	private static double calculateMinToBurn(int calsToBurn, double bmr, double met)
	{
		double timeHrs = calsToBurn / (bmr * met / 24);
		return timeHrs * 60;
	}
}
