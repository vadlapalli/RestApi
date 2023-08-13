package com.springboot.demo.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.springboot.demo.constants.AppConstants;
import com.springboot.demo.entity.CitizenPlan;
import com.springboot.demo.repository.CitizenPlanRepository;


@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
        
    //Cash Plan
		
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus(AppConstants.STR_APPROVED);
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenfitAmount(50000);
		
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Johnson");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus(AppConstants.STR_DENIED);
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setDenialRsn(AppConstants.STR_RENTAL_INCOME);
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Smitha");
		c3.setGender(AppConstants.STR_FE_MALE);
		c3.setPlanName("Cash");
		c3.setPlanStatus(AppConstants.STR_TERMINATED);
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));	
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenfitAmount(40000);
		c3.setTerminateRsn(AppConstants.STR_PROPERTY_INCOME);
		
	//Food Plan
		
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Malinga");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus(AppConstants.STR_APPROVED);
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenfitAmount(50000);
		
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Mitchel");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus(AppConstants.STR_DENIED);
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setDenialRsn(AppConstants.STR_RENTAL_INCOME);
		
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Swetha");
		c6.setGender(AppConstants.STR_FE_MALE);
		c6.setPlanName("Food");
		c6.setPlanStatus(AppConstants.STR_TERMINATED);
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));	
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenfitAmount(40000);
		c6.setTerminateRsn(AppConstants.STR_PROPERTY_INCOME);
		
	// Medical Plan
		
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Roben");
		c7.setGender("Male");
		c7.setPlanName(AppConstants.STR_MEDICAL);
		c7.setPlanStatus(AppConstants.STR_APPROVED);
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenfitAmount(50000);
		
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Kevin");
		c8.setGender("Male");
		c8.setPlanName(AppConstants.STR_MEDICAL);
		c8.setPlanStatus(AppConstants.STR_DENIED);
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		c8.setDenialRsn(AppConstants.STR_RENTAL_INCOME);
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Sri");
		c9.setGender(AppConstants.STR_FE_MALE);
		c9.setPlanName(AppConstants.STR_MEDICAL);
		c9.setPlanStatus(AppConstants.STR_TERMINATED);
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));	
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenfitAmount(40000);
		c9.setTerminateRsn(AppConstants.STR_PROPERTY_INCOME);
		
	//Employment Plane
		
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Rahul");
		c10.setGender("Male");
		c10.setPlanName(AppConstants.STR_EMPLOYEEMENT);
		c10.setPlanStatus(AppConstants.STR_APPROVED);
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenfitAmount(50000);
		
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Neeraj");
		c11.setGender("Male");
		c11.setPlanName(AppConstants.STR_EMPLOYEEMENT);
		c11.setPlanStatus(AppConstants.STR_DENIED);
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setDenialRsn(AppConstants.STR_RENTAL_INCOME);
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("saraswathi");
		c12.setGender(AppConstants.STR_FE_MALE);
		c12.setPlanName(AppConstants.STR_EMPLOYEEMENT);
		c12.setPlanStatus(AppConstants.STR_TERMINATED);
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));	
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenfitAmount(40000);
		c12.setTerminateRsn(AppConstants.STR_PROPERTY_INCOME);
		
		java.util.List<CitizenPlan> list =Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);

	}

}
