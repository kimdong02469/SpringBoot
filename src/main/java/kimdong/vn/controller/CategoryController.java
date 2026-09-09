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
import kimdong.vn.entity.Category;
import kimdong.vn.model.CategoryModel;
import kimdong.vn.service.ICategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("")
	public String list(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Category> list;
        if (keyword != null && !keyword.trim().isEmpty()) {
            list = categoryService.findByCategorynameContaining(keyword);
            model.addAttribute("keyword", keyword); // Giữ lại từ khóa trên ô input
        } else {
            list = categoryService.findAll();
        }
        model.addAttribute("categories", list);
        return "admin/categories/list";
    }

	@GetMapping("add")
	public String add(ModelMap model) {
		CategoryModel cateModel = new CategoryModel();
		cateModel.setIsEdit(false);
		model.addAttribute("category", cateModel);
		return "admin/categories/addOrEdit";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel cateModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}
		Category entity = new Category();
		BeanUtils.copyProperties(cateModel, entity);
		categoryService.save(entity);

		String message = Boolean.TRUE.equals(cateModel.getIsEdit()) ? "Category is Edited!!!!!!!!"
				: "Category is saved!!!!!!!!";

		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/categories", model);
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") long id) {
		Optional<Category> optCategory = categoryService.findById(id);
		CategoryModel cateModel = new CategoryModel();
		if (optCategory.isPresent()) {
			Category entity = optCategory.get();
			BeanUtils.copyProperties(entity, cateModel);
			cateModel.setIsEdit(true);
			model.addAttribute("category", cateModel);
			return new ModelAndView("admin/categories/addOrEdit", model);
		}
		model.addAttribute("message", "Category is not existed!!!!");
		return new ModelAndView("forward:/admin/categories", model);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") long id) {
		categoryService.deleteById(id);
		model.addAttribute("message", "Category is deleted!!!!");
		return new ModelAndView("redirect:/admin/categories", model);
	}
}