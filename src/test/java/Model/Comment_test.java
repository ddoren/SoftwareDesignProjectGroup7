package Model;

import org.junit.jupiter.api.Test;
import softwaredesign.sdproject.model.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Comment_test {
    private Comment test_comment = new Comment(1,"Very nice",3,2);

    @Test
    void getID(){
        assertEquals(1,test_comment.getCommentId());
    }
    @Test
    void setID(){
        test_comment.setCommentId(2);
        assertEquals(2,test_comment.getCommentId());
    }
    @Test
    void getComment(){
        assertEquals("Very nice",test_comment.getComment());
    }
    @Test
    void setComment(){
        test_comment.setComment("Not bad");
        assertEquals("Not bad",test_comment.getComment());
    }
    @Test
    void getArticleID(){
        assertEquals(3,test_comment.getArticleId());
    }
    @Test
    void setArticleID(){
        test_comment.setArticleId(4);
        assertEquals(4,test_comment.getArticleId());
    }
}
