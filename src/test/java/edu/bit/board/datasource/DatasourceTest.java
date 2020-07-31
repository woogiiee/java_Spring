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

@RunWith(SpringRunner.class)//�̰� ��ü�����ε� IOC�����̳ʸ� ������ش�. Ioc�ȿ� �ؿ� �ִ� ���� �־��ش�.
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
