```java
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
``