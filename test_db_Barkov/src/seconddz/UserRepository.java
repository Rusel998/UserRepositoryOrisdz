package seconddz;

import java.util.List;

public interface UserRepository extends CRUDRepository<User>{
    List<User> findByAge(Integer age);
    List<User> findByEmail(String email);
    List<User> findByPassword(String password);
    List<User> findByRole(String role);
}
