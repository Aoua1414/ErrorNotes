package com.error.ErrorNotes.Repository;

import com.error.ErrorNotes.Model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    @Query(value = "SELECT * FROM solution WHERE id_probleme=:id_probleme", nativeQuery = true)
    public Solution FIND_SOLUTION_BY_ID_PROBLEME(@Param("id_probleme") Long id_probleme);

}
