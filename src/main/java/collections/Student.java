package collections;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String zipCode;

    public Student(String studentId, String firstName, String lastName, String streetAddress, String zipCode) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private Student(StudentBuilder builder) {
        this.studentId=builder.studentId;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.streetAddress=builder.streetAddress;
        this.zipCode = builder.zipCode;
    }

    //Builder Class
    public static class StudentBuilder{

        private String studentId;
        private String firstName;
        private String lastName;
        private String streetAddress;
        private String zipCode;

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
