package softwaredesign.sdproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "articles", schema = "system_dev_exam_app", catalog = "")
public class Article {
    private int articleId;
    private String category;
    private String title;
    private String body;

    public Article() {}

    public Article(int articleId,String category,String title,String body){
        this.articleId=articleId;
        this.category=category;
        this.title=title;
        this.body=body;
}
    @Id
    @Column(name = "article_id", nullable = false)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 15)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 150)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "body", nullable = false, length = 10000)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return articleId == article.articleId &&
                Objects.equals(category, article.category) &&
                Objects.equals(title, article.title) &&
                Objects.equals(body, article.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, category, title, body);
    }
}
