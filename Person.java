public  abstract class Person {
    private  String name;
    private  String contactNum;

    public Person( String name,String contactNum) {

        this.name = name;
        this.contactNum=contactNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }







}
