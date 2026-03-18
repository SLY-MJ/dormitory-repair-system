package week01.project.pojo;

public class Repair {
    private String id;
    private String feature;
    private String adminId;
    private String studentId;
    private String description;
    private String status;

    public Repair() {
    }

    public Repair(String feature, String studentId, String description, String status) {
        this.feature = feature;
        this.studentId = studentId;
        this.description = description;
        this.status = status;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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
}
