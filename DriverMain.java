import java.util.Scanner;


interface Taxable {
    double SALES_TAX = 0.07;    
    double INCOME_TAX = 0.105;  
    
    void calcTax();
}


class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;
    
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public void calcTax() {
        double yearlySalary = salary * 12;
        double tax = yearlySalary * INCOME_TAX;
        System.out.printf("Income Tax for %s (ID: %d): $%.2f%n", name, empId, tax);
    }
    
    // Getters
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}


class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;
    
    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public void calcTax() {
        double taxPerUnit = price * SALES_TAX;
        double totalTax = taxPerUnit * quantity;
        System.out.printf("Sales Tax for Product ID %d: $%.2f (%.2f per unit)%n", 
                         pid, totalTax, taxPerUnit);
    }
    
    
    public int getPid() { return pid; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}


public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.println("Enter Employee Details:");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double salary = scanner.nextDouble();
        
        
        System.out.println("\nEnter Product Details:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Unit Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        
        
        Employee employee = new Employee(empId, name, salary);
        Product product = new Product(pid, price, quantity);
        
        
        System.out.println("\nTax Calculations:");
        employee.calcTax();
        product.calcTax();
        
        scanner.close();
    }
}
