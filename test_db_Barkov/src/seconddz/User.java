package seconddz;

public class User {
    private String firstName;
    private int age;
    private String secondName;
    private Long id;
    private String email;
    private String password;
    private String role;

    public User(Long id, String firstName, String secondName, int age, String email, String password, String role) {
        this.firstName = firstName;
        this.age = age;
        this.secondName = secondName;
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getId() {
        return id;
    }
}
