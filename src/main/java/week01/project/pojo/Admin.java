package week01.project.pojo;

public class Admin extends User {
    private int phone;

    public Admin() {
        super();
    }

    public Admin(String id, String name, String password, String role, int phone) {
        super(id, password, name, role);
        this.phone = phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return this.phone;
    }

}
