package jpabucket.bucketlist.Controller;

import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.domain.item.ToDo;
import jpabucket.bucketlist.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/buckets")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "buckets/bucketList";
    }

    @GetMapping("buckets/{itemId}/edit")
    public String updateBucketForm(@PathVariable("itemId") Long itemId, Model model) {
        ToDo bucket = (ToDo) itemService.findOne(itemId);

        TodoForm form = new TodoForm();
        form.setId(bucket.getId());
        form.setGoal(bucket.getGoal());
        form.setWay(bucket.getWay());
        form.setTargetDate(bucket.getTargetDate());

        model.addAttribute("form", form);
        return "buckets/updateBucketForm";
    }

    @PostMapping("buckets/{itemId}/edit")
    public String updateBucket(@PathVariable String itemId, @ModelAttribute("form") TodoForm form) {

        ToDo toDo = new ToDo();
        toDo.setId(form.getId());
        toDo.setGoal(form.getGoal());
        toDo.setWay(form.getWay());
        toDo.setTargetDate(form.getTargetDate());

        itemService.saveItem(toDo);
        return "redirect:/buckets";
    }
}
