package base.wolf.model;

public class User {
    private String id;

    private String username;

    private String password;

    private String email;

    private String name;

    private String sex;

    private String birthday;

    private String address;

    private String tel;

    private String qq;

    private String image;

    private String sfjh;

    private String sfzx;

    private String sfhf;

    private String sfpl;

    private String sffx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSfjh() {
        return sfjh;
    }

    public void setSfjh(String sfjh) {
        this.sfjh = sfjh;
    }

    public String getSfzx() {
        return sfzx;
    }

    public void setSfzx(String sfzx) {
        this.sfzx = sfzx;
    }

    public String getSfhf() {
        return sfhf;
    }

    public void setSfhf(String sfhf) {
        this.sfhf = sfhf;
    }

    public String getSfpl() {
        return sfpl;
    }

    public void setSfpl(String sfpl) {
        this.sfpl = sfpl;
    }

    public String getSffx() {
        return sffx;
    }

    public void setSffx(String sffx) {
        this.sffx = sffx;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getSfjh() == null ? other.getSfjh() == null : this.getSfjh().equals(other.getSfjh()))
            && (this.getSfzx() == null ? other.getSfzx() == null : this.getSfzx().equals(other.getSfzx()))
            && (this.getSfhf() == null ? other.getSfhf() == null : this.getSfhf().equals(other.getSfhf()))
            && (this.getSfpl() == null ? other.getSfpl() == null : this.getSfpl().equals(other.getSfpl()))
            && (this.getSffx() == null ? other.getSffx() == null : this.getSffx().equals(other.getSffx()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getSfjh() == null) ? 0 : getSfjh().hashCode());
        result = prime * result + ((getSfzx() == null) ? 0 : getSfzx().hashCode());
        result = prime * result + ((getSfhf() == null) ? 0 : getSfhf().hashCode());
        result = prime * result + ((getSfpl() == null) ? 0 : getSfpl().hashCode());
        result = prime * result + ((getSffx() == null) ? 0 : getSffx().hashCode());
        return result;
    }
}