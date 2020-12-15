package com.example.demo.sample;


import com.example.demo.sample.view.SampleView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;
    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public SampleView findAll(Integer page, Integer size) {
        SampleView sampleView = new SampleView();
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        Page<Sample> samples = sampleRepository.findAll(PageRequest.of(page, size, sort));
        log.debug("]------] SampleService::findAll.samples [-----[  {}", samples.getContent());
        return sampleView;
    }

}
