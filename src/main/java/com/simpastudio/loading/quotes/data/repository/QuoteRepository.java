package com.simpastudio.loading.quotes.data.repository;

import com.simpastudio.loading.quotes.data.model.internal.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
    @Query(value = "SELECT * FROM Quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote random();

    @Query(value = "SELECT * FROM Quote ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<Quote> random(int limit);
}
