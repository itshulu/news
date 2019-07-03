package top.sl.news.entity;

public class Type {
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
        return "Type{" +
                "type_id='" + type_id + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }
}
