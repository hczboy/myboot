package com.myboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboot.aspect.TimeCount;
import com.myboot.config.AmazonProperties;
import com.myboot.entity.Book;
import com.myboot.repository.ReadingListRepostitory;


@Controller
@RequestMapping("/readinglist")
public class ReadingListController {
	
	private ReadingListRepostitory readingListRepo;
	
	@Autowired
	private AmazonProperties amazonPros;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private GaugeService gaugeService;
	

	@Autowired
	public ReadingListController(ReadingListRepostitory readingListRepo) {
		super();
		this.readingListRepo = readingListRepo;
	}
	@TimeCount
	@RequestMapping(value="/{reader}", method=RequestMethod.GET)
	public String readerBooks(@PathVariable("reader") String reader, Model model){
		List<Book> readingList = readingListRepo.findByReader(reader);
		Optional.ofNullable(readingList).ifPresent(r->{
			model.addAttribute("books", r);
			model.addAttribute("amazonID", amazonPros.getAssociateId());
			});
		return "readingList";
	}
	
	@RequestMapping(value="/{reader}", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book){
		book.setReader(reader);
		readingListRepo.save(book);
		counterService.increment("books.saved");
		gaugeService.submit("books.last.saved", System.currentTimeMillis());
		return "redirect:/readinglist/{reader}";
	}
}
