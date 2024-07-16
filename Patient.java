public class Patient extends  Person {
    private String name;
    private String birthday;
    private String contactNum;

    private String patientId;



    public String getBirthday() {
        return birthday;
    }



    public Patient(String name, String birthday, String contactNum, String patientId) {
        super(name,contactNum);
        this.birthday = birthday;
        this.patientId = patientId;
    }

    public char getPatientType(){
        return patientId.charAt(0);
    }

    public String getPatientId() {
        return this.patientId;
    }


}

