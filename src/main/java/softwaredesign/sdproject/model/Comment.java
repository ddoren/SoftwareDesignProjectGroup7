package softwaredesign.sdproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "system_dev_exam_app", catalog = "")
public class Comment {
    private int commentId;
    private String comment;
    private int articleId;
    private  int userId;
public Comment(){}

public Comment(int commentId, String comment, int articleId, int userId){
    this.commentId=commentId;
    this.comment=comment;
    this.articleId=articleId;
    this.userId=userId;
}
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
    @Column(name = "article_id", nullable = false)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    @Basic
    @Column(name = "user_id",nullable = false)
    public int getUserId(){return userId;}

    public void setUserId(int userId){this.userId=userId;}

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
