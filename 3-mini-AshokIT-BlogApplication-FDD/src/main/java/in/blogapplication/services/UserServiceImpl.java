package in.blogapplication.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.blogapplication.bindings.LoginForm;
import in.blogapplication.bindings.RegisterForm;
import in.blogapplication.entities.UserDtls;
import in.blogapplication.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HttpSession session;

	@Override
	public boolean registration(RegisterForm form) {

		// Check email is already available

		UserDtls user = userRepo.findByEmail(form.getEmail());

		if (user != null) {
			return false;
		}

		// TODO copy details from form to object
		UserDtls userEntity = new UserDtls();
		BeanUtils.copyProperties(form, userEntity);

		// save details into db
		userRepo.save(userEntity);

		return true;
	}

	@Override
	public String login(LoginForm form) {

		// TODO check user name and password matching
		UserDtls entity = userRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		
		if (entity == null) {
			return "Invalid Credentials";
		}
		//create session and store user data in session
		session.setAttribute("userId", entity.getUserId());
		System.out.println(entity.getUserId());
		
		return "Success";

	}
}
