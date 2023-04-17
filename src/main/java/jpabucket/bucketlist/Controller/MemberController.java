package jpabucket.bucketlist.Controller;

import jpabucket.bucketlist.domain.Infomation;
import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberform";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Infomation infomation = new Infomation(form.getNickname(), form.getPassword(), form.getEmail());

        Member member = new Member();
        member.setName(form.getName());
        member.setInfomation(infomation);

        memberService.join(member);
        return "redirect:/";
    }
}
