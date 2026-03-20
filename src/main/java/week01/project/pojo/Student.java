package week01.project.pojo;

public class Student extends User {
    private String buildingNo;
    private String roomNo;

    public Student() {
        super();
    }

    public Student(String id, String name, String password, String role, String buildingNo, String roomNo) {
        super(id, password, name, role);
        this.buildingNo = buildingNo;
        this.roomNo = roomNo;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }


}
