package cn.itcast.travel.domain;

public class Admin {
    private int id;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String telephone;//手机号码

    public Admin() { }

    public Admin(int id, String username, String password, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
