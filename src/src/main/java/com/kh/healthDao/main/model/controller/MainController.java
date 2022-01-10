package com.kh.healthDao.main.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.healthDao.main.model.service.BannerService;
import com.kh.healthDao.main.model.vo.Banner;
import com.kh.healthDao.shopping.model.service.ShoppingService;


@Controller
public class MainController {

	/*
	 * @GetMapping(value= {"/", "/main"}) public String main() { return "main/main";
	 * }
	 */

	@GetMapping(value= {"/", "/main"})
	public ModelAndView findBannerRankList(ModelAndView mv) {
		
		List<Banner> bannerList = bannerService.bannerRankList();
		
		mv.addObject("bannerList", bannerList);
		mv.setViewName("main/main");
		
		return mv;
	}
	
	@PostMapping(value= {"/", "/main"})
	public String redirectMain() {
		return "redirect:/";
	}
	
	@GetMapping("/reco")
	public String reco() {
		return "admin/reco";
	}
	@GetMapping("/time")
	public String time() {
		return "admin/time";
	}

	private BannerService bannerService;
	
	@Autowired
	public MainController(BannerService bannerService) {
		this.bannerService = bannerService;
	}
	
	
	@GetMapping("/banner")
	public ModelAndView findBannerList(ModelAndView mv, @RequestParam int page) {
		
		Map<String, Object> map = bannerService.findBannerList(page);
		
		mv.addObject("bannerList", map.get("bannerList"));
		mv.addObject("listCount", map.get("listCount"));
		mv.addObject("pi", map.get("pi"));
		mv.setViewName("admin/banner");
		
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/banner/delete")
	public int deleteBanner(@RequestBody int[] addList) {
		int result = 0;
		for(int i = 0; i < addList.length; i++) {
			result += bannerService.deleteBanner(addList[i]);			
		}
		System.out.println(result);
		
		return result;
	}

	@PostMapping("/banner/select")
	@ResponseBody
	public Banner modifyBanner(int main_no) {
		Banner banner = bannerService.bannerSelect(main_no);
		return banner;
	}

	@PostMapping("/banner/update")
	@ResponseBody
	public int updateBanner(int main_no, String main_name, String main_url, String imgUpload, String main_status, int main_rank) {
		System.out.println(imgUpload);
		
		Map<String, Object> map = new HashMap<>();
		map.put("main_no", main_no);
		map.put("main_name", main_name);
		map.put("main_url", main_url);
		map.put("imgUpload", imgUpload);
		map.put("main_status", main_status);
		map.put("main_rank", main_rank);
		
		int result = bannerService.bannerUpdate(map);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

//	private ShoppingService shoppingService;
//	
//	@Autowired
//	public MainController(ShoppingService shoppingService) {
//		this.shoppingService = shoppingService;
//	}
//	// 추천상품 검색
//	@GetMapping("/reco")
//	public ModelAndView pdtList(ModelAndView mv) {
//		Map<String, Object> map = shoppingService.pdtList();
//		mv.addObject("pdtList", map.get("pdtList"));
//		mv.setViewName("admin/reco");
//		return mv;
//	}
}