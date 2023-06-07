package jpabucket.bucketlist.Controller;

import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.service.ItemService;
import jpabucket.bucketlist.service.MemberService;
import jpabucket.bucketlist.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;
    private final MemberService memberService;
    private  final ItemService itemService;

    @GetMapping("/register")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "register/registerForm";
    }
}
