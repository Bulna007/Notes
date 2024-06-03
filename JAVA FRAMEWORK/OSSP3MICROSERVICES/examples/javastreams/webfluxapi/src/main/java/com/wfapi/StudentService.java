package com.wfapi;

import com.wfapi.dto.StudentDto;
import com.wfapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Flux<StudentDto> getStudentsByName(String studentName) {
        return studentRepository.findByStudentName(studentName)
                .map(e -> StudentDto.of()
                        .no(e.getStudentNo())
                        .name(e.getStudentName())
                        .mobile(e.getMobileNo())
                        .emailAddress(e.getEmailAddress()).build());
    }

    @Transactional(readOnly = true)
    public Mono<Long> getNoOfStudentsByGender(String gender) {
        return studentRepository.countByGender(gender);
    }
}
