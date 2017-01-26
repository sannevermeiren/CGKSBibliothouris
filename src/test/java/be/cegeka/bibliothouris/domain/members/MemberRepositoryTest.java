package be.cegeka.bibliothouris.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulienl on 26/01/2017.
 */
public class MemberRepositoryTest {
    MemberRepository memberRepository = new MemberRepository();
    List<Member > testList = new ArrayList<>();
    Member member1 = new Member("556", "Elize", "Lodewycks", "eenStraat", 12, 9999, "verWeg");
    Member member2 = new Member("459", "Jens", "Devriendt", "eenAndereStraat", 56, 1569, "ergens");
    Member member3 = new Member("59", "Kevin", "familienaam", "eenDerdeStraat", 45, 789, "ergensAnders");


    @Test
    public void getAllMembers() throws Exception {
        memberRepository.addMember(member1);
        memberRepository.addMember(member2);
        memberRepository.addMember(member3);
        testList.add(member1);
        testList.add(member2);
        testList.add(member3);
        Assertions.assertThat(memberRepository.getAllMembers()).isEqualTo(testList);
    }



}