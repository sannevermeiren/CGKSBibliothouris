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

    public String getMemberDetails(Member member)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("First name: " + member.getFirstName() +" ");
        sb.append("Last name: " + member.getLastName()+" ");
        sb.append("City: " + member.getCity()+" ");
        sb.append("Number: " + member.getInss());
        return sb.toString();
    }

    public String getAllMemberDetails()
    {
        StringBuilder sb = new StringBuilder();
        if(members.size()>0)
        {
            for (Member member : members)
            {
                sb.append(getMemberDetails(member));
            }
            return sb.toString();
        }
        else
        {
            return ("No members found");
        }
    }
}
