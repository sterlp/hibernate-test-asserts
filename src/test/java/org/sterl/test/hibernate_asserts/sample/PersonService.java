package org.sterl.test.hibernate_asserts.sample;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    
    public PersonEntity create(String name) {
        return personRepository.save(new PersonEntity(name));
    }
}
