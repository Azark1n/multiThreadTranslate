package ru.azarkin.translateApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.azarkin.translateApi.model.TranslateRequest;

public interface TranslateRepository extends PagingAndSortingRepository<TranslateRequest, Long>, JpaSpecificationExecutor<TranslateRequest>, JpaRepository<TranslateRequest, Long> {
}
