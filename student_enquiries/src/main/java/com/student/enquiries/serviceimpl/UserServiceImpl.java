package com.student.enquiries.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.enquiries.binding.LoginForm;
import com.student.enquiries.binding.SignUpForm;
import com.student.enquiries.binding.UnlockForm;
import com.student.enquiries.entities.Users;
import com.student.enquiries.repositories.UserRepository;
import com.student.enquiries.service.UserService;
import com.student.enquiries.utils.EmailUtils;
import com.student.enquiries.utils.PwdUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private HttpSession session;

	@Override
	public boolean signup(SignUpForm form) {

		Users user = userRepo.findByEmail(form.getEmail());

		if (user != null) {
			return false;
		}
		Users entity = new Users();
		BeanUtils.copyProperties(form, entity);
		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPassWord(tempPwd);
		entity.setAcctStatus("Locked");
		userRepo.save(entity);
		String to = form.getEmail();
		String subject = "Unlock your account | ASHOK IT";

		StringBuilder body = new StringBuilder("");
		body.append("<h1>Use below temporary password to unlock your account</h1>");
		body.append("Temporary pwd:" + tempPwd);
		body.append("<br/>");
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\"> Click here to unlock your account");
		emailUtils.sendEmail(to, body.toString(), subject);

		return true;

	}

	@Override
	public boolean unlockAcct(UnlockForm form) {

		Users entity = userRepo.findByEmail(form.getEmail());

		if (entity.getPassWord().equals(form.getTempPwd())) {

			entity.setPassWord(form.getNewPwd());
			entity.setAcctStatus("UnLocked");
			userRepo.save(entity);
			return true;
		}
		return false;
	}

	@Override
	public String loginForm(LoginForm form) {
		Users entity = userRepo.findByEmailAndPassWord(form.getEmail(), form.getPassWord());
		if (entity == null) {
			return "Invalid Credentials";
		}

		if (entity.getAcctStatus().equals("Locked")) {
			return "Your Acct is Locked";
		}

		// create session and store user data in session
		session.setAttribute("userId", entity.getUserId());
		return "Success";
	}

	@Override
	public boolean forgotPwd(String email) {

		// check record is available in db with given mail id

		Users entity = userRepo.findByEmail(email);

		// if record is not available send err mesg

		if (entity == null) {

			return false;

		}

		// is record is available send password to email and send success mesg
		String subject = "Recover Password";
		String body = "Your Password :: " + entity.getPassWord();

		emailUtils.sendEmail(email, body, subject);

		return true;
	}

}
