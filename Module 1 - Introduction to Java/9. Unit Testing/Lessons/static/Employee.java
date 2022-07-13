public class Employee {
    private String name;
    private String position;

    private static int hiredCount;

    private static final String COMPANY_NAME = "COMPUMUNDOHYPERMEGARED";

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;

        Employee.hiredCount++;
    }
  
    public Employee(Employee source) {
        this.name = source.name;
        this.position = source.position;
    }

    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
  
    public void greet(String company) {
        if (company.equals(Employee.COMPANY_NAME)) {
            System.out.println("Welcome!");
        }
    }

    public static int getHiredCount() {
        return hiredCount;
    }



    public String toString() {

        return "\tName: " + name + "\tPosition: " + this.position + "\tCompany: " + Employee.COMPANY_NAME + "\n";
    }
}
