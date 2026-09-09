package kimdong.vn.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import kimdong.vn.entity.User;
import kimdong.vn.model.UserModel;
import kimdong.vn.service.IUserService;

@Controller
@RequestMapping("admin/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword) {
		List<User> list;
		if (keyword != null && !keyword.trim().isEmpty()) {
			list = userService.search(keyword);
			model.addAttribute("keyword", keyword);
		} else {
			list = userService.findAll();
		}
		model.addAttribute("users", list);
		return "admin/users/list";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		UserModel userModel = new UserModel();
		userModel.setIsEdit(false);
		model.addAttribute("user", userModel);
		return "admin/users/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("user") UserModel userModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/users/addOrEdit");
		}
		User entity = new User();
		BeanUtils.copyProperties(userModel, entity);
		userService.save(entity);

		String message = Boolean.TRUE.equals(userModel.getIsEdit()) ? "User is Edited!" : "User is Saved!";
		model.addAttribute("message", message);
		return new ModelAndView("redirect:/admin/users", model);
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Long id) {
		Optional<User> optUser = userService.findById(id);
		UserModel userModel = new UserModel();
		if (optUser.isPresent()) {
			User entity = optUser.get();
			BeanUtils.copyProperties(entity, userModel);
			userModel.setIsEdit(true);
			model.addAttribute("user", userModel);
			return new ModelAndView("admin/users/addOrEdit", model);
		}
		model.addAttribute("message", "User is not existed!");
		return new ModelAndView("redirect:/admin/users", model);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Long id) {
		userService.deleteById(id);
		model.addAttribute("message", "User is deleted!");
		return new ModelAndView("redirect:/admin/users", model);
	}
}