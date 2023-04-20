package jpabucket.bucketlist.Controller;

import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.domain.item.ToDo;
import jpabucket.bucketlist.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BucketController {

    private final ItemService itemService;

    @GetMapping("/buckets/new")
    public String createForm(Model model) {
        model.addAttribute("form", new TodoForm());
        return "buckets/createBucketForm";
    }

    @PostMapping("/buckets/new")
    public String create(TodoForm form) {
        ToDo toDo = new ToDo();
        toDo.setGoal(form.getGoal());
        toDo.setWay(form.getWay());
        toDo.setHeart(0);
        toDo.setRegisterDate(LocalDateTime.now());
        toDo.setTargetDate(form.getTargetDate());

        itemService.saveItem(toDo);
        return "redirect:/";
    }
}
