package com.dardell.PhoneBookAPI.repository;

import com.dardell.PhoneBookAPI.services.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {
}
