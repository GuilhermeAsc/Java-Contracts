package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.Enum.WorkerLeve;
public class Main{
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Enter department's name: ");
    String DepartmentName = sc.nextLine();
    System.out.println("Enter worker data: ");
    System.out.println("Name: ");
    String WorkerName = sc.nextLine();
    System.out.println("Level: ");
    String WorkerLevel = sc.nextLine();
    System.out.println("Base Salary: ");
    double bSalary = sc.nextDouble();

    Worker worker = new Worker(WorkerName,WorkerLeve.valueOf(WorkerLevel), bSalary, new Department(DepartmentName));

    System.out.println("How many contracts to this worker? ");
    int n = sc.nextInt();

    for(int i = 1; i<n;i++){
      System.out.println("Enter Contract #" + i + " data: ");
      System.out.println("Date (DD/MM/YYYY): ");
      Date contractDate = sdf.parse(sc.next());
      System.out.println("Value per hour ");
      double ValuePerHourr = sc.nextDouble();
      System.out.println("Duration(hours): ");
      int hours = sc.nextInt();
      HourContract contract = new HourContract(contractDate,ValuePerHourr,hours);
      worker.addContract(contract);

    }
    System.out.println();
    System.out.println("Enter month and year to calculate income(MM/YYYY)");
    String monthAndyear = sc.next();
    int month = Integer.parseInt(monthAndyear.substring(0,2));
    int year = Integer.parseInt(monthAndyear.substring(3));
    System.out.println("Name: " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println("Income for " + monthAndyear + ": " + String.format("%.2f", worker.income(year, month)));




    


    sc.close();
  }
}