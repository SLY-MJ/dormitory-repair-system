package week01.project.pojo;

public class Repair {
    private int id;
    private String adminId;
    private String studentId;
    private String description;
    private String status;
    private String date;

    public Repair() {
    }

    public Repair(String studentId, String adminId, String description, String status, String date) {
        this.adminId = adminId;
        this.studentId = studentId;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }
}
