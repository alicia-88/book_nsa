package com.nsa.book_nsa.repository;

import com.nsa.book_nsa.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<Format, Long> {
   Format getByName(String name);
}
