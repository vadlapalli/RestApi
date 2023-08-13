package com.student.enquiries.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.enquiries.binding.DashboardResponse;
import com.student.enquiries.binding.EnquiryForm;
import com.student.enquiries.binding.EnquirySearchCriteria;
import com.student.enquiries.entities.Course;
import com.student.enquiries.entities.EnquiryStatus;
import com.student.enquiries.entities.StudentEnquiry;
import com.student.enquiries.entities.Users;
import com.student.enquiries.repositories.CourseRepo;
import com.student.enquiries.repositories.EnquiryRepo;
import com.student.enquiries.repositories.StatusRepo;
import com.student.enquiries.repositories.UserRepository;
import com.student.enquiries.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EnquiryRepo enquiryRepo;

	@Autowired
	private HttpSession session;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private StatusRepo statusRepo;

	@Override
	public DashboardResponse getDashboardData(Integer userId) {

		DashboardResponse response = new DashboardResponse();

		Optional<Users> findById = userRepo.findById(userId);

		if (findById.isPresent()) {
			Users userEntity = findById.get();

			List<StudentEnquiry> enquiries = userEntity.getEnquiries();

			Integer totalCnt = enquiries.size();

			Integer enrolledCnt = enquiries.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
					.collect(Collectors.toList()).size();

			Integer lostCnt = enquiries.stream().filter(e -> e.getEnqStatus().equals("Lost"))
					.collect(Collectors.toList()).size();

			response.setTotEnquiriesCnt(totalCnt);
			response.setEnrolledEnquiriesCnt(enrolledCnt);
			response.setLostEnquiriesCnt(lostCnt);
		}
		return response;
	}

	@Override
	public List<String> getCourses() {
		List<Course> findAll = courseRepo.findAll();

		List<String> names = new ArrayList<>();

		for (Course entity : findAll) {
			names.add(entity.getCourseName());

		}

		return names;
	}

	@Override
	public List<String> getEnquiryStatus() {

		List<EnquiryStatus> findAll = statusRepo.findAll();

		List<String> statusList = new ArrayList<>();

		for (EnquiryStatus entity : findAll) {
			statusList.add(entity.getStatusName());
		}

		return statusList;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {

		StudentEnquiry enqEntity = new StudentEnquiry();
		BeanUtils.copyProperties(form, enqEntity);

		Integer userId = (Integer) session.getAttribute("userId");

		Optional<Users> userEntity = userRepo.findById(userId);
		if (userEntity.isPresent()) {
			Users user = userEntity.get();
			enqEntity.setUser(user);
		}
		enquiryRepo.save(enqEntity);

		return true;
	}

	@Override
	public List<StudentEnquiry> getEnquiries() {
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<Users> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			Users userEntity = findById.get();
			return userEntity.getEnquiries();
		}
		return Collections.emptyList();
	}

	@Override
	public List<StudentEnquiry> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId) {
		Optional<Users> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			Users userEntity = findById.get();
			List<StudentEnquiry> enquiries = userEntity.getEnquiries();

			if (null != criteria.getCourseName() && !"".equals(criteria.getCourseName())) {
				enquiries = enquiries.stream().filter(e -> e.getCourseName().equals(criteria.getCourseName()))
						.collect(Collectors.toList());
			}
			if (null != criteria.getEnqStatus() && !"".equals(criteria.getEnqStatus())) {
				enquiries = enquiries.stream().filter(e -> e.getEnqStatus().equals(criteria.getEnqStatus()))
						.collect(Collectors.toList());
			}
			if (null != criteria.getClassMode() && !"".equals(criteria.getClassMode())) {
				enquiries = enquiries.stream().filter(e -> e.getClassMode().equals(criteria.getClassMode()))
						.collect(Collectors.toList());

			}
			return enquiries;

		}
		return Collections.emptyList();
	}

}
