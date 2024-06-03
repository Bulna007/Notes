package com.wfapi.api;

import com.wfapi.StudentService;
import com.wfapi.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentApiController {
    private final StudentService studentService;

    @GetMapping(value = "/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<StudentDto> getStudentsByName(@PathVariable("name") String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping(value = "/{gender}/count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> getNoOfStudentsByGender(@PathVariable("gender") String gender) {
        return studentService.getNoOfStudentsByGender(gender);
    }

}
