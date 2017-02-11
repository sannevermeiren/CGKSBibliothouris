package be.cegeka.bibliothouris.domain.members;

import be.cegeka.bibliothouris.domain.members.Member;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MemberServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    public void addMember_ShouldCallMemberRepository() throws Exception {
        memberService.addMember("123", "paulien" , "lemay", "hendrik dewildestraat", 24, 8501, "bissegem");

        verify(memberRepository).addMember(new Member("123", "paulien" , "lemay", "hendrik dewildestraat", 24, 8501, "bissegem"));
    }

    @Test
    public void getAllUsers() throws Exception {
        Member member1 = new Member("556", "Elize", "Lodewycks", "eenStraat", 12, 9999, "verWeg");
        Member member2 = new Member("459", "Jens", "Devriendt", "eenAndereStraat", 56, 1569, "ergens");

        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member1, member2));

        assertThat(memberService.getAllMembers()).containsOnly(member1, member2);
    }

}