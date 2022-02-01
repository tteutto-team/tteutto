package edu.kh.tteutto.common;

import java.text.SimpleDateFormat;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Util {

	// Sweetalert 세팅용 메소드
	public static void swalSetMessage(String title, String text, String icon, RedirectAttributes ra) {
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);
	}
	
	// 크로스 사이트 스크립트 방지 처리 메소드
	public static String XSS(String param) {
		String result = param;
		if (param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}

		return result;
	}
	
	// 파일명 변경 메소드
	public static String fileRename(String originFileName) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

		return date + str + ext;
	}

	// 개행 문자 변경 메소드
	public static String changeNewLine(String content) {
		return content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	}

	// 개행 문자 변경 메소드2
	public static String changeNewLine2(String content) {
		return content.replaceAll("<br>", "\r\n");
	}
}
