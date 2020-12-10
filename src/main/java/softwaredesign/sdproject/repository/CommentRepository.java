package softwaredesign.sdproject.repository;

import softwaredesign.sdproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentsByArticleId(int article_id);
}
