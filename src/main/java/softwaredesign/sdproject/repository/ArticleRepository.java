package softwaredesign.sdproject.repository;

import softwaredesign.sdproject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
