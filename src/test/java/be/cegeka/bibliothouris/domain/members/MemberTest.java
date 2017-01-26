package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paulienl on 26/01/2017.
 */
public class MemberTest {
    Member member = new Member("123", "lemay", "paulien", "hendrik dewildestr", 24, 8501 , "bissegem");

    @Test
    public void getStreet() throws Exception {
    Assertions.assertThat(member.getStreet()).isEqualTo("hendrik dewildestr");
    }

    @Test
    public void getInss() throws Exception {
        Assertions.assertThat(member.getInss()).isEqualTo("123");

    }

    @Test
    public void getLastName() throws Exception {
        Assertions.assertThat(member.getLastName()).isEqualTo("lemay");

    }

    @Test
    public void getFirstName() throws Exception {
        Assertions.assertThat(member.getFirstName()).isEqualTo("paulien");

    }

    @Test
    public void getNumber() throws Exception {
        Assertions.assertThat(member.getNumber()).isEqualTo(24);

    }

    @Test
    public void getPostalCode() throws Exception {
        Assertions.assertThat(member.getPostalCode()).isEqualTo(8501);

    }

    @Test
    public void getCity() throws Exception {
        Assertions.assertThat(member.getCity()).isEqualTo("bissegem");

    }

}