package com.example.demo.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Slf4j
@Component
public class SampleHandler {

    private final SampleRepository sampleRepository;
    private final SampleService sampleService;

    public SampleHandler(SampleRepository sampleRepository, SampleService sampleService) {
        this.sampleRepository = sampleRepository;
        this.sampleService = sampleService;
    }


    /**
     * GET Samples
     */
    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("]-----] SampleHandler::findAll call [-----[ ");
        Integer page = request.queryParam("page").isPresent() ? Integer.parseInt(request.queryParam("page").get()) - 1 : 0;
        Integer size = request.queryParam("pagesize").isPresent() ? Integer.parseInt(request.queryParam("pagesize").get()) : 20;


//        return request.principal()
//                .flatMap(p -> {
//                    log.debug("]-----] p [-----[ {}", p.getName());
//                    return Mono.just(sampleRepository.findAll(PageRequest.of(page, size, sort)));
//                })
        return Mono.just(sampleService.findAll(page, size))
                .flatMap(samples -> ok().body(fromValue(samples)))
                .switchIfEmpty(badRequest().build());

    }

    /**
     * GET a Sample
     */

    public Mono<ServerResponse> findById(ServerRequest request) {
        log.info("]-----] SampleHandler::findById call [-----[ ");
        Long id = Long.parseLong(request.pathVariable("id"));
//        return request.principal()
//                .flatMap(p -> Mono.just(sampleRepository.findById(id).get()))
        return Mono.just(sampleRepository.findById(id).get())
                .flatMap(sample -> ok().body(fromValue(sample)))
                .switchIfEmpty(notFound().build());

    }


    /**
     * POST a Sample
     */
    public Mono<ServerResponse> save(ServerRequest request) {
        log.info("]-----] SampleHandler::save call [-----[ ");

        return request.principal()
                .flatMap(p -> request.bodyToMono(Sample.class))
                .flatMap(sample -> Mono.just(sampleRepository.save(sample)))
                .flatMap(sample -> ok().body(fromValue(sample)))
                .switchIfEmpty(notFound().build());

    }

}
