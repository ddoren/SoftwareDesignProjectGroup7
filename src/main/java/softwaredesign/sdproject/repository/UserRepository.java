package softwaredesign.sdproject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import softwaredesign.sdproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional

public interface UserRepository extends JpaRepository<User, Integer> {

        @Modifying
        @Query("update User u set u.email=:email ,u.password=:password,u.permission=:permission where u.userId=:id")
        void updateUser(@Param("email") String email, @Param("password")String password, @Param("permission") String permission, @Param("id") int id);


}
