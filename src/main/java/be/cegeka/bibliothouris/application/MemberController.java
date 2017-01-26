package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.members.Member;
import be.cegeka.bibliothouris.domain.members.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Member> getMembers() {
        return memberService.getAllMembers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addUser(@RequestParam(value = "inss", required = true) String inss,
                 @RequestParam(value = "lastName", required = true) String lastName,
                 @RequestParam(value = "firstName", required = true) String firstName,
                 @RequestParam(value = "street", required = true) String street,
                 @RequestParam(value = "number", required = true) int number,
                 @RequestParam(value = "postalCode", required = true) int postalCode,
                 @RequestParam(value = "city", required = true) String city)

    {
        memberService.addMember(inss, lastName, firstName,street, number, postalCode, city);
    }

    @RequestMapping(path="/memberDetails", method = RequestMethod.GET)
    public
    @ResponseBody
    String getAllDetails()
    {
        return memberService.getAllMemberDetails();
    }

}
