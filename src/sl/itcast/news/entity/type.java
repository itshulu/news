package sl.itcast.news.entity;

public class type {
    private String type_id;
    private String typename;

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "type{" +
                "type_id='" + type_id + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }
}
