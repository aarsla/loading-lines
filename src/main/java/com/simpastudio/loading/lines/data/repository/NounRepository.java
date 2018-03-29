package com.simpastudio.loading.lines.data.repository;

import com.simpastudio.loading.lines.data.model.internal.Noun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NounRepository extends CrudRepository<Noun, Long> {
    @Query(value = "SELECT * FROM Noun ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Noun random();
}
