public class Person {
    private String firstname;
    private String lastName;

    public Person(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        return lastName;
    }

    public String setFirstname(String firstname) {
        return firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
