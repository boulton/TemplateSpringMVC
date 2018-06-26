package security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoEncodingEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence arg0) {
		return arg0.toString();
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		return arg0.toString().equals(arg1);
	}
	

}
