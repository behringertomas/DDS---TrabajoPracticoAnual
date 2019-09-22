package test;

public class MappingTest {
	import org.junit.Before;
	import org.junit.Test;
	import utn.dds.herencia.Project;
	import utn.dds.herencia.SmallProject;
	import utn.dds.relaciones.*;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import java.util.Collections;

	import static org.junit.Assert.*;

	public class RelationsMappingTest {

	    private EntityManager entityManager;

	    @Before
	    public void before() {
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST_PERSISTENCE_UNIT");
	        entityManager = factory.createEntityManager();
	    }


	    @Test
	    public void testConnection() {
	        // creo un nuevo proyecto
	        Project project = new SmallProject();

	        // id es null porque no esta persistido
	        assertNull(project.getId());

	        // persisto en DB
	        EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(project);
	        transaction.commit();

	        // id no es nulo
	        assertNotNull(project.getId());

	        // comparo identidad
	        Project projectPersisted = entityManager.find(Project.class, project.getId());
	        assertEquals(project, projectPersisted);

	    }


	    @Test
	    public void oneToOne() {
	        Long id;

	        // creo entidades
	        EmployeeInfo info = new EmployeeInfo();
	        info.setName("Lionel Messi");
	        Employee employee = new Employee();
	        employee.setSalary(123456);
	        employee.setInfo(info);

	        // persito employee (info tmb se persiste por cascade)
	        EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(employee);
	        id = employee.getId();
	        transaction.commit();

	        // chequeo que se haya persitido
	        assertNotNull(employee.getId());
	        assertNotNull(info.getId());

	        // recupero employee (e info)
	        Employee retrievedEmployee = entityManager.find(Employee.class, id);

	        // chequeo
	        assertEquals(retrievedEmployee, employee);
	        assertEquals(retrievedEmployee.getInfo(), info);
	    }

	    @Test
	    public void oneToManyBidirectional() {
	        Order order = new Order();
	        Customer customer = new Customer();
	        customer.setName("Lionel Messi");
	        customer.setOrders(Collections.singletonList(order));
	        order.setCustomer(customer);

	        EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(customer);
	        transaction.commit();

	        Customer retrievedCustomer = entityManager.find(Customer.class, customer.getId());
	        assertEquals(1, retrievedCustomer.getOrders().size());
	        assertEquals(retrievedCustomer, retrievedCustomer.getOrders().get(0).getCustomer());
	    }

	    @Test
	    public void manyToMany() {
	        PhoneNumber number = new PhoneNumber();
	        number.setValue("1234");

	        Customer customer = new Customer();
	        customer.setName("Lionel Messi");

	        customer.setPhones(Collections.singleton(number));
	        number.setCustomers(Collections.singleton(customer));

	        EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(customer);
	        transaction.commit();

	        Customer retrievedCustomer = entityManager.find(Customer.class, customer.getId());
	        assertEquals(1, retrievedCustomer.getPhones().size());
	        PhoneNumber retrievedPhone = retrievedCustomer.getPhones().stream().findFirst().orElse(null);
	        assertEquals(1, retrievedPhone.getCustomers().size());

	        assertEquals(customer, retrievedCustomer);
	        assertEquals(number, retrievedPhone);
	    }


	}

}
