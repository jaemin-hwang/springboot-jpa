package com.example.demo.sample;

import com.example.demo.common.model.ActiveType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Long> {

    Page<Sample> findAll(Pageable pageable);

    List<Sample> findAllByActive(ActiveType activeType);

}