package ir.maktab.models;

import ir.maktab.base.models.BaseModel;

public class Tag extends BaseModel<Long> {
    Long id;
    String title;

    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Tag{" + "id=" + id + ", title='" + title + '\'' + '}';
    }
}
