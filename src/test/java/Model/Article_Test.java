package Model;
import org.junit.jupiter.api.Test;
import softwaredesign.sdproject.model.Article;

import static org.junit.jupiter.api.Assertions.*;

public class Article_Test {
    private Article temp_article= new Article(1,"Diverse","Dorin","Dorin fute capu");

    @Test
    void getID(){
        assertEquals(1,temp_article.getArticleId());
    }
    @Test
    void setId(){
        temp_article.setArticleId(2);
        assertEquals(2,temp_article.getArticleId());
    }
    @Test
    void getCategory(){
        assertEquals("Diverse",temp_article.getCategory());
    }
    @Test
    void setCategory(){
        temp_article.setCategory("Horror");
        assertEquals("Horror",temp_article.getCategory());
    }
    @Test
    void getTitle(){
        assertEquals("Dorin",temp_article.getTitle());
    }
    @Test
    void setTitle(){
        temp_article.setTitle("Not Dorin");
        assertEquals("Not Dorin",temp_article.getTitle());
    }
    @Test
    void getBody(){
        assertEquals("Dorin fute capu",temp_article.getBody());
    }
    @Test
    void setBody(){
        temp_article.setBody("Dorin patan");
        assertEquals("Dorin patan",temp_article.getBody());
    }
}
