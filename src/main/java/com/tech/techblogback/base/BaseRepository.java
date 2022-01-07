package com.tech.techblogback.base;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {

    @Query("select e from #{#entityName} e where e.id = ?1")
    Optional<T> findById(ID id);

    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted is false")
    Optional<T> findByIdAndNotDeleted(ID id);

    @Override
    @Query("select e from #{#entityName} e where e.deleted is false")
    List<T> findAll();

    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted is true")
    Optional<T> findDeletedById(ID id);


}
