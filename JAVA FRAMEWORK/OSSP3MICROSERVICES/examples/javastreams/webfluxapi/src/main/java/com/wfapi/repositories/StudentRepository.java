package com.wfapi.repositories;

import com.wfapi.entities.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    Flux<Student> findByStudentName(String studentName);

    Mono<Long> countByGender(String gender);
}
