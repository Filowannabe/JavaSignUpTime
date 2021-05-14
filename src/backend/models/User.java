package backend.models;

public class User {

    private String id;
    private String name;
    private String phone;
    private String mail;

    public User(String id, String name, String phone, String mail) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setMail(mail);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
