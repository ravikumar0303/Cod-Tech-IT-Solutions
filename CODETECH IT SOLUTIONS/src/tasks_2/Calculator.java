package tasks_2;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		int opctions = 0;
		double num1;
		double num2;
		double result = 0;

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome TO Basic Calculator");
		do {
			System.out.println(" <1>. Addition \n <2>. subtraction \n <3>. multiplication \n <4>. division \n <5>. Exit");
//		 opctions= sc.next().charAt(0);
			opctions = sc.nextInt();
    
//		  int i=sc.nextInt();
			if (opctions == -1 || opctions == 0) {
				System.out.println(" please Enter A Valid Opctions");
				return;
			}
			

			switch (opctions) {
			// performs addition between numbers
			case 1:
				System.out.println("Enter your First No.:");
				num1 = sc.nextDouble();
				System.out.println("Enter your Second No.:");
				num2 = sc.nextDouble();
				result = num1 + num2;
				System.out.println("Answer:" + num1 + " + " + num2 + " = " + result);

				break;
			// performs subtractions between numbers
			case 2: {
				System.out.println("Enter your First No.:");
				num1 = sc.nextDouble();
				System.out.println("Enter your Second No.:");
				num2 = sc.nextDouble();
				result = num1 - num2;
				System.out.println("Answer:" + num1 + " - " + num2 + " = " + result);
				break;
			}
			// performs multiplications between numbers
			case 3: {
				System.out.println("Enter your First No.:");
				num1 = sc.nextDouble();
				System.out.println("Enter your Second No.:");
				num2 = sc.nextDouble();
				result = num1 * num2;
				System.out.println("Answer:" + num1 + " * " + num2 + " = " + result);
				break;
			}
			// performs Division between numbers
			case 4: {
				System.out.println("Enter your First No.:");
				num1 = sc.nextDouble();
				System.out.println("Enter your Second No.:");
				num2 = sc.nextDouble();
				result = num1 / num2;
				System.out.println("Answer:" + num1 + " / " + num2 + " = " + result);
				break;
			}
			case 5: {
				sc.close();
				System.out.println(" Thanku For Visiting !!!! \n  Have A Grate Day \n");
				break;
			}
			// performs Default case
			default:
				System.out.println("Invaid Operator....");
				break;

			}

		} while (true);

//		sc.close();
	}
}