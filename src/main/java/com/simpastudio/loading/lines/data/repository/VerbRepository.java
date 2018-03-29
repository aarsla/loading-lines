package com.simpastudio.loading.lines.data.repository;

import com.simpastudio.loading.lines.data.model.internal.Verb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerbRepository extends CrudRepository<Verb, Long> {
    @Query(value="SELECT * FROM Verb ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Verb random();
}
