package com.swapp.swapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.swapp.swapp.model.*;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Integer>{

    @Query(value = "SELECT s.* FROM SWIPE_TABLE s WHERE s.user_id = :otherID AND s.book_id IN (SELECT b.id FROM BOOK_TABLE b WHERE b.user_id = :userID)", nativeQuery = true)
    List<Swipe> isMatch(@Param("userID") Integer userID, @Param("otherID") Integer otherID);
    
}
