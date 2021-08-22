package ir.maktab.base.models;

public class BaseModel <ID> {
    ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
