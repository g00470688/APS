import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class emp_manager
{
	public static void main(String[] args) throws IOException
	{
		Scanner getEmployee = new Scanner(new File("Employees.txt"));
		FileWriter fwriter = new FileWriter("Employees.txt", true);
		Random rd = new Random();
		int employeeId;
		String employeeName;
		PrintWriter empFile = new PrintWriter(fwriter);
		Scanner kb = new Scanner(System.in);
		String  choice;

		do{
			String fullString;
			LocalTime timeNow = LocalTime.now();
			String currentTime = timeNow.format(DateTimeFormatter.ofPattern("HH:mm"));
			//System.out.print(currentTime);
			System.out.print("""
					Welcome to the Employee Manager!
					Choose one from the following options:
					1: Add Employee.
					2: Delete employee.
					3: View list of employees.
					4: Add a task to employee.
					0: Exit.
					""");
			System.out.print("enter your choice: ");
			choice = kb.nextLine();

			switch (choice) {
				case "1":
					System.out.print("enter  full employee name(name_surname):");
					employeeName = kb.nextLine();
					employeeId = rd.nextInt(9999999);
					empFile.printf("%s#%d\n",employeeName, employeeId);
					System.out.printf("New employe added!\nName: %S\nID: %d\n",employeeName, employeeId );
					break;
				case "2":
					break;
				case "3":
					do
					{
						String name, surname, id;
						fullString = getEmployee.nextLine();
						name = fullString.substring(0, fullString.indexOf("_"));
						surname = fullString.substring(fullString.indexOf("_")+1, fullString.indexOf("#"));
						id = fullString.substring(fullString.indexOf("#")+1);
						System.out.printf("\nEmployee ID: %s\nName: %s\nSurname: %s\n",id, name, surname );
					}while(getEmployee.hasNext());
					break;

				case "4":
					fullString = getEmployee.nextLine();
					int index = fullString.indexOf(":");
					System.out.println(index);
					if(index > -1)
					{
						System.out.println("Employee already has a task!");
					}
					else
					{

					}
					break;
			}
		}while(!(choice.equals("0")));

		empFile.close();
	}
}