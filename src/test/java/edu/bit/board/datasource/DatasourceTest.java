package edu.bit.board.datasource;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)//이거 자체만으로도 IOC컨테이너를 만들어준다. Ioc안에 밑에 있는 것을 넣어준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DatasourceTest {
	
	@Inject
	DataSource dataSource;

	

	
	@Test
	public void testDatasource() {
		System.out.println(dataSource);
	}
	

}
