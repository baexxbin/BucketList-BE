//package jpabucket.bucketlist.Controller;
//
//import jpabucket.bucketlist.domain.Information;
//import jpabucket.bucketlist.domain.Member;
//import jpabucket.bucketlist.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//
//    private final MemberService memberService;
//
//    @GetMapping("/members/new")
//    public String createForm(Model model) {
//        model.addAttribute("memberForm", new MemberForm());
//        return "members/createMemberForm";
//    }
//
////    @PostMapping("/members/new")
////    public String create(@Valid MemberForm form, BindingResult result) {
////
////        if (result.hasErrors()) {
////            return "members/createMemberForm";
////        }
////
////        Information infomation = new Information();
////        infomation.setPoint(0);
////        infomation.setEmail(form.getEmail());
////        infomation.getNickname(form.getNickname());
////        infomation.setPassword(form.getPassword());
////
////        Member member = new Member();
////        member.setName(form.getName());
////        member.setInfomation(infomation);
////
////        memberService.join(member);
////        return "redirect:/";
////    }
//
//
//    @GetMapping("/members")
//    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }
//}
