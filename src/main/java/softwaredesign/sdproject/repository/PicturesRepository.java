package softwaredesign.sdproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softwaredesign.sdproject.model.Pictures;

import java.util.List;

public interface PicturesRepository extends JpaRepository<Pictures,Integer> {
    List<Pictures> findPicturesByArticleId( int articleId);
}
