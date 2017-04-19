package com.myboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboot.config.AmazonProperties;
import com.myboot.entity.Book;
import com.myboot.repository.ReadingListRepostitory;


@Controller
@RequestMapping("/")
public class ReadingListController {
	
	private ReadingListRepostitory readingListRepo;
	
	@Autowired
	private AmazonProperties amazonPros;

	@Autowired
	public ReadingListController(ReadingListRepostitory readingListRepo) {
		super();
		this.readingListRepo = readingListRepo;
	}
	
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
		return "redirect:/{reader}";
	}
}
