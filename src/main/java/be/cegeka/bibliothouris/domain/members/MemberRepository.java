package be.cegeka.bibliothouris.domain.members;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public List<Member> getAllMembers() {
        return members;
    }

    public void addMember(Member member){
        members.add(member);
    }
}
