package ir.maktab.models;

import ir.maktab.base.models.BaseModel;

import java.sql.Timestamp;

public class Article  extends BaseModel<Long> {
    Long id;
    String title;
    String brief;
    String content;
    Timestamp createDate;
    boolean isPublished;
    Timestamp lastUpdateDate;
    Timestamp initialPublishDate;

    Article() {
    }

    Article(Long id,
            String title,
            String brief,
            String content,
            Timestamp createDate,
            boolean isPublished,
            Timestamp lastUpdateDate,
            Timestamp publishDate) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.lastUpdateDate = lastUpdateDate;
        this.initialPublishDate = publishDate;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Timestamp getInitialPublishDate() {
        return initialPublishDate;
    }

    public void setInitialPublishDate(Timestamp initialPublishDate) {
        this.initialPublishDate = initialPublishDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", isPublished=" + isPublished +
                ", lastUpdateDate=" + lastUpdateDate +
                ", initialPublishDate=" + initialPublishDate +
                '}';
    }
}
