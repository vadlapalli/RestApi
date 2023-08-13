package in.blogapplication.services;

import in.blogapplication.bindings.LoginForm;
import in.blogapplication.bindings.RegisterForm;

public interface UserService {
	
	public boolean registration(RegisterForm form);
	
	public String login(LoginForm form);
	
	

}
