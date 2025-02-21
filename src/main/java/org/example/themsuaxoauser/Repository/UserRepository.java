package org.example.themsuaxoauser.Repository;

import org.example.themsuaxoauser.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//jpa repository
//kế thừa JpaRepository để sử dụng các phương thức CRUD
//chứa các method như save(), findById(), deleteById(), findAll()...
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
