package be.cegeka.bibliothouris.domain.members;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    private String inss;


    public Member() {

    }

    private String lastName;
    private String firstName;
    private String street;
    private int number;
    private int postalCode;
    private String city;

    public Member(String inss, String lastName, String firstName, String street, int number, int postalCode, String city) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }



    public String getStreet()
    {
        return street;
    }
    public String getInss() {
        return inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getNumber() {
        return number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (number != member.number) return false;
        if (postalCode != member.postalCode) return false;
        if (!inss.equals(member.inss)) return false;
        if (!lastName.equals(member.lastName)) return false;
        if (!firstName.equals(member.firstName)) return false;
        if (!street.equals(member.street)) return false;
        return city.equals(member.city);
    }

    @Override
    public int hashCode() {
        int result = inss.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + number;
        result = 31 * result + postalCode;
        result = 31 * result + city.hashCode();
        return result;
    }
}
