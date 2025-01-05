import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Menu
{
	public static void main(String[] args)
	{
		String run;
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("""
                ==============================
                           Mod Finder
                ==============================
                """);
		do
		{
			Scanner getEmployee = new Scanner(new File("Employees.txt"));
		FileWriter fwriter = new FileWriter("Employees.txt", true);
		Random rd = new Random();
		int employeeId;
		String employeeName;
		PrintWriter empFile = new PrintWriter(fwriter);
		Scanner kb = new Scanner(System.in);
		String  choice;

			System.out.println("Enter an integers(a mod b): ");
			a = Integer.parseInt(sc.next());
			b = Integer.parseInt(sc.next());
			if (a > 0)
			{
				System.out.println(a % b);
			}else
			{
				while (a < 0)
				{
					a += b;
				}
				System.out.println(a % b);
			}
			System.out. println("would you like to run again? (y/n)");
			run = sc.nextLine();
			sc.nextLine();
		}while(run.equalsIgnoreCase("Y"));

	}
}