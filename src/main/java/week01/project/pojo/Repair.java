package week01.project.pojo;

public class Repair {
    private String id;
    private String adminId;
    private String studentId;
    private String description;
    private String status;
    private String date;

    public Repair() {
    }

    public Repair(String id, String studentId, String description, String status, String date) {
        this.id = id;
        this.studentId = studentId;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
