
package com.iluwatar.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Repository pattern mediates between the domain and data mapping layers using a collection-like
 * interface for accessing domain objects. A system with complex domain model often benefits from a
 * layer that isolates domain objects from the details of the database access code and in such
 * systems it can be worthwhile to build another layer of abstraction over the mapping layer where
 * query construction code is concentrated. This becomes more important when there are a large
 * number of domain classes or heavy querying. In these cases particularly, adding this layer helps
 * minimize duplicate query logic.
 * <p>
 * In this example we utilize Spring Data to automatically generate a repository for us from the
 * {@link Person} domain object. Using the {@link PersonRepository} we perform CRUD operations on
 * the entity, moreover, the query by {@link org.springframework.data.jpa.domain.Specification} are
 * also performed. Underneath we have configured in-memory H2 database for which schema is created
 * and dropped on each run.
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point
   * 
   * @param args
   *          command line args
   */
  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    PersonRepository repository = context.getBean(PersonRepository.class);

    Person peter = new Person("Peter", "Sagan", 17);
    Person nasta = new Person("Nasta", "Kuzminova", 25);
    Person john = new Person("John", "lawrence", 35);
    Person terry = new Person("Terry", "Law", 36);

    // Add new Person records
    repository.save(peter);
    repository.save(nasta);
    repository.save(john);
    repository.save(terry);

    // Count Person records
    LOGGER.info("Count Person records: {}", repository.count());

    // Print all records
    List<Person> persons = (List<Person>) repository.findAll();
    for (Person person : persons) {
      LOGGER.info(person.toString());
    }

    // Update Person
    nasta.setName("Barbora");
    nasta.setSurname("Spotakova");
    repository.save(nasta);

    LOGGER.info("Find by id 2: {}", repository.findOne(2L));

    // Remove record from Person
    repository.delete(2L);

    // count records
    LOGGER.info("Count Person records: {}", repository.count());

    // find by name
    Person p = repository.findOne(new PersonSpecifications.NameEqualSpec("John"));
    LOGGER.info("Find by John is {}", p);

    // find by age
    persons = repository.findAll(new PersonSpecifications.AgeBetweenSpec(20, 40));

    LOGGER.info("Find Person with age between 20,40: ");
    for (Person person : persons) {
      LOGGER.info(person.toString());
    }

    repository.deleteAll();
    
    context.close();

  }
}
