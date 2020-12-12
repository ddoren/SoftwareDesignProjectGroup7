package softwaredesign.sdproject.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "pictures",schema = "system_dev_exam_app")
public class Pictures {
    private int pictureId;
    private byte[] content;
    private int articleId;
    @Id
    @Column(name ="pictureId" ,nullable = false)
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
    @Lob
    @Column(name = "content",nullable = false)
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
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
                Arrays.equals(content, pictures.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pictureId, articleId);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pictureId=" + pictureId +
                ", content=" + Arrays.toString(content) +
                ", articleId=" + articleId +
                '}';
    }
}
