package be.cegeka.bibliothouris.domain.members;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class MemberService {
    public MemberService()
    {

    }

    //@Inject
   // private MemberRepository memberRepository;
    @Inject
    private MemberRepositoryWithRealDatabase memberRepositoryWithRealDatabase;


    private final AtomicLong counter = new AtomicLong();

    public void addMember(String inss, String lastName, String firstName, String street, int number, int postalCode, String city){
        memberRepositoryWithRealDatabase.save(new Member(inss,  lastName,  firstName,  street, number,  postalCode,  city));
    }

    public Iterable<Member> getAllMembers() {
        return memberRepositoryWithRealDatabase.findAll();
    }

    public String getAllMemberDetails(){
        return memberRepositoryWithRealDatabase.findAll().toString();
    }

}
