package softwaredesign.sdproject.repository;

import softwaredesign.sdproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
