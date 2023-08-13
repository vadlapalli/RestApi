package io.spring.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("oracledb")
@Primary
public class OracleDBReportDao implements ReportDao {

	public void getdata() {
		System.out.println("Getting data from oracle db...");

	}

}
