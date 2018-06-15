package sl.itcast.news.entity;

public class admin {
    private String adminid;
    private String adminname;
    private String adminpass;

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    @Override
    public String toString() {
        return "admin{" +
                "adminid='" + adminid + '\'' +
                ", adminname='" + adminname + '\'' +
                ", adminpass='" + adminpass + '\'' +
                '}';
    }
}
