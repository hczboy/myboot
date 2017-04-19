package com.myboot;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myboot.entity.Book;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MybootApplication.class)
@WebAppConfiguration
public class MockMvcWebTests {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testReadlingList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("readingList"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("books"))
		.andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
	}
	
	@Test
	public void postBook() throws Exception{
		mockMvc.perform(post("/readingList")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "BT")
				.param("author", "BA")
				.param("isbn", "1234")
				.param("description", "BD"))
		.andExpect(status().is3xxRedirection())
		.andExpect(header().string("Location", "/readingList"));
		
		Book expectedBook = new Book();
		expectedBook.setId(1L);
		expectedBook.setReader("readingList");
		expectedBook.setTitle("BT");
		expectedBook.setAuthor("BA");
		expectedBook.setIsbn("1234");
		expectedBook.setDescription("BD");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/readingList"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("readingList"))
		.andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.hasSize(1)))
		.andExpect(MockMvcResultMatchers.model().attribute("books", 
				Matchers.contains(Matchers.samePropertyValuesAs(expectedBook))));
		
		
	}
}
