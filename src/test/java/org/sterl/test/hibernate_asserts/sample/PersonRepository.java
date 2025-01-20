package org.sterl.test.hibernate_asserts.sample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>{

}
