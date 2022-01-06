package com.kh.healthDao.main.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.healthDao.main.model.dao.BannerMapper;
import com.kh.healthDao.main.model.vo.Banner;
import com.kh.healthDao.main.model.vo.PageInfo;


@Service("BannerService")
public class BannerServiceImpl implements BannerService{
	
	private final BannerMapper bannerMapper;

	@Autowired
	public BannerServiceImpl(BannerMapper bannerMapper) {
		this.bannerMapper = bannerMapper;
	}

	@Override
	public List<Banner> bannerAllList() {
		return bannerMapper.bannerAllList();
	}

	@Override
	public int insertBanner(Banner banner, String originFileName, String path, String savedName) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("banner", banner);
		map.put("originFileName", originFileName);
		// map.put("path", path);
		map.put("path", "/images/upload/main/");
		map.put("savedName", savedName);
		System.out.println(banner + ", " + path + ", " + savedName);
		
		int result1 = bannerMapper.insertBanner(map);
		int result2 = bannerMapper.insertFile(map);
		int result3 = bannerMapper.insertFileDB();
		
		int result = 0;
				
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			result = 1;
		}
				
		return result;
	}
	

}
