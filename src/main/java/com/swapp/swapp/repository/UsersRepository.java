package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
    Optional<Users> findByLoginAndPassword(String login, String password);
    Optional<Users> findByLogin(String login);

    public boolean existsByEmail(String email);

    public boolean existsByLogin(String login);

    @Query(value="SELECT * FROM USERS_TABLE u WHERE (((u.lat - :coordx) * (u.lat - :coordx)) + ((u.longi - :coordy) * (u.longi - :coordy))) <= :max", nativeQuery = true)
    List<Users> findAllBooks(@Param("coordx") double coordx, @Param("coordy") double coordy, @Param("max") double max);
    

}
