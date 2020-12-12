package softwaredesign.sdproject.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "pictures",schema = "system_dev_exam_app")
public class Pictures {
    private int pictureId;
    private Blob content;
    private int articleId;

    public Pictures() {
    }

    public Pictures(int pictureId, Blob content, int articleId) {
        this.pictureId = pictureId;
        this.content = content;
        this.articleId = articleId;
    }

    @Id
    @Column(name ="picture_id" ,nullable = false)
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
    @Lob
    @Column(name = "content",nullable = false)
    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }
    @Basic()
    @Column(name = "article_id",nullable = false)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pictures pictures = (Pictures) o;
        return pictureId == pictures.pictureId &&
                articleId == pictures.articleId &&
                Objects.equals(content, pictures.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pictureId, content, articleId);
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pictureId=" + pictureId +
                ", content=" + content +
                ", articleId=" + articleId +
                '}';
    }
}
