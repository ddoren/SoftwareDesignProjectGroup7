package softwaredesign.sdproject.repository;

import softwaredesign.sdproject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByCategoryContaining(String category);
}
