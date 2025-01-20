# Setup
[Maven](https://central.sonatype.com/search?q=hibernate-asserts&namespace=org.sterl.test)

```xml
<dependency>
    <groupId>org.sterl.test</groupId>
    <artifactId>hibernate-asserts</artifactId>
    <version>1.0.x</version>
    <scope>test</scope>
</dependency>
```
# Example

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
```
