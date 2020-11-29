package softwaredesign.sdproject.repository;

import softwaredesign.sdproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
