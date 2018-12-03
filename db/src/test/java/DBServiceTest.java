import dto.Employee;
import org.assertj.core.api.AbstractObjectAssert;
import org.junit.Assert;
import org.junit.Test;
import service.DBService;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class DBServiceTest {

    @Test
    public void insert_validUser_returnPersistedUser() throws SQLException, ClassNotFoundException {

        DBService service = new DBService();
        Employee tosave = new Employee();

        tosave.setDob("1996-04-09");
        tosave.setFirstName("Jorge");
        tosave.setLastName("Cardoso");
        tosave.setGender("M");

        Employee savedEmployee = service.insertEmployee(tosave);

        Assert.assertTrue(savedEmployee.getFirstName().equals(tosave.getFirstName()));

        assertThat(savedEmployee).isEqualToIgnoringGivenFields(tosave, "number", "hireDate");

        }
    }


