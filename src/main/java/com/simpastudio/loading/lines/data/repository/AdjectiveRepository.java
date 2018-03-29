package com.simpastudio.loading.lines.data.repository;

import com.simpastudio.loading.lines.data.model.internal.Adjective;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjectiveRepository extends CrudRepository<Adjective, Long> {
    @Query(value="SELECT * FROM Adjective ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Adjective random();
}
