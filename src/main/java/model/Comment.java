package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "system_dev_exam_app", catalog = "")
public class Comment {
    private int commentId;
    private String comment;
    private Integer articleId;

    @Id
    @Column(name = "comment_id", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 150)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "article_id", nullable = true)
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(commentId, comment1.commentId) &&
                Objects.equals(comment, comment1.comment) &&
                Objects.equals(articleId, comment1.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, comment, articleId);
    }
}
