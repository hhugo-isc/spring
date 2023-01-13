package com.hh.springmvcdemo.validacion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		boolean result = false;

		if (arg0 != null) {
			result = arg0.startsWith(this.coursePrefix);
		}

		return result;
	}

}
