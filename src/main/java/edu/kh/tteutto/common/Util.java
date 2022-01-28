package edu.kh.tteutto.common;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Util {

	// Sweetalert 세팅용 메소드
	public static void swalSetMessage(String title, String text, String icon, RedirectAttributes ra) {
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);
	}
}
