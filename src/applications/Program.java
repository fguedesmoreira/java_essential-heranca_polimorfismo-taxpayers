package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of taxpayers: ");
		int numberOfTaxpayers = sc.nextInt();
		
		List<TaxPayer> list = new ArrayList<>();
		
		for (int i = 1; i <= numberOfTaxpayers; i++) {
			
			System.out.printf("Taxpayer #%d data:%n", i);
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			
			while (Character.toUpperCase(type) != 'I' && Character.toUpperCase(type) != 'C') {
				System.out.print("Allowed values (i/c): ");
				type = sc.next().charAt(0);
			}
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			
			if (Character.toUpperCase(type) == 'I') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
		}
		
		sc.close();
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double totalTaxes = 0.0;
		
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
			totalTaxes += tp.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);
		
	}

}