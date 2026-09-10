package kimdong.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index"; // Trỏ tới file index.jsp nằm trong thư mục views
	}
}