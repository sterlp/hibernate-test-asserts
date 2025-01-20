package org.sterl.test.hibernate_asserts.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.sterl.test.hibernate_asserts.HibernateAsserts;

import jakarta.persistence.EntityManager;

@SpringBootTest(classes = {SampleApp.class, HibernateAssertsTest.Config.class})
@TestPropertySource(locations = "classpath:application-test.yml")
class HibernateAssertsTest {
    
    @Configuration
    public static class Config {
        @Bean
        HibernateAsserts hibernateAsserts(EntityManager entityManager) {
            return new HibernateAsserts(entityManager);
        }
    }

    @Autowired
    private PersonService subject;
    @Autowired
    private HibernateAsserts hibernateAsserts;

    @Test
    void testCreatePerson() {
        // GIVEN
        var name = "Paul";
        
        // WHEN
        subject.create(name);
        
        // THEN
        hibernateAsserts
            .assertInsertCount(1)
            .assertUpdateCount(0)
            .assertTrxCount(1);
    }

}
