package io.spring.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MySQLDBReportDao implements ReportDao {

	public void getdata() {
		System.out.println("Getting data from mysql db...");

	}

}
