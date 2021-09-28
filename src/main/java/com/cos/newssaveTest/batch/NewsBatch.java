package com.cos.newssaveTest.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newssaveTest.domain.News;
import com.cos.newssaveTest.domain.NewsRepository;
import com.cos.newssaveTest.util.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {

	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;
	
	@Scheduled(fixedDelay=1000*60*5)
	public void newsCrawAndSave() {
		List<News> newsList =  naverCraw.collect6();
		newsRepository.saveAll(newsList);
	}
}
