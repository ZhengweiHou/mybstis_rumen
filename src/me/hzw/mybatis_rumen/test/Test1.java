package me.hzw.mybatis_rumen.test;

import java.io.IOException;
import java.io.InputStream;

import me.hzw.mybatis_rumen.domain.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {
	public static void main(String[] args) {

		String resource = "conf.xml";
		InputStream is = Test1.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);

		SqlSession session = sessionFactory.openSession();

		String statement = "me.hzw.mybatis_rumen.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 1);
		System.out.println(user);

		session.close();
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
