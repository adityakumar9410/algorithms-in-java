import java.util.Objects;
class Employee {
    private String firstName;
    private String lastName;
    private int Id;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Id == employee.Id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, Id);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Id=" + Id +
                '}';
    }
}

public class EmployeeLinkedList {

    public class EmployeeNode {
        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }
        public String toString(){
            return employee.toString();
        }
    }

    private EmployeeNode head;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.next = head;
        head = node;
    }

    public void printList() {
        EmployeeNode curr = head;
        System.out.print("Head - > ");
        while (curr != null) {
            System.out.print(curr);
            System.out.print(" - > ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Employee adityaKumar = new Employee("Aditya", "Kumar", 121);
        Employee sumitRaj = new Employee("Sumit", "Raj", 131);
        Employee dineshYadav = new Employee("Dinesh", "Yadav", 141);
        Employee ankushSingh = new Employee("Ankush", "Singh", 151);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(adityaKumar);
        list.addToFront(ankushSingh);
        list.addToFront(sumitRaj);
        list.addToFront(dineshYadav);
       list.printList();
    }

}
