package com.example.demo_foodMap.constants;

public enum SearchRtnCode {
	VALUE_REQUIRED("400", "Value error(Can not be null or empty)!"), // ���o��J�� �ũάO null
	PRICE_ERROR("400", "Price cannot be null or 0!"), 				 // ��J������~
	COMMENT_ERROR("400", "Comment only be allowed 1~5 range!"), 	 // ��J�������~
	MEALS_EXISTED("403", "�\�I�w�s�b!"), 				 			 // �\�I�w�s�b
	STORE_EXISTED("403", "���a�w�s�b!"), 				 			 // ���a�w�s�b
	CREATE_SUCCESSFUL("200", "Created success!"),					 // �Ыظ�Ʀ��\
	STORE_NOT_EXISTED("400", "���a���s�b�A�L�k�Ыص��!"), 			 // ���a�ä��s�b
	DATA_NOT_FOUND("400", "Data is not found!"), 					 // �d�L���
	DATA_IS_FOUND("200", "Data is found!"), 						 // �����
	
	CHOOSE_SUCCESSFUL("200", "Choose success!"), // �Ыظ�Ʀ��\
	UPDATE_SUCCESSFUL("200", "Update data success!"), // �ק��Ʀ��\
	DELETE_SUCCESSFUL("200", "Delete data success!"), // �R����Ʀ��\
	
	CHOOSE_FAIL("200", "Choose fail!"), // �Ыظ�ƥ���
	DAY_ERROR("400", "Day error!"), // ��J������~
	CREDIT_ERROR("400", "Credit error!"), // ��J�Ǥ����~
	TIME_ERROR("400", "Time error!"), // ��J�ɶ����~
	
	COURSE_NOT_EXISTED("400", "Course doesn't exist!"), // ���Ұ�ä��s�b
	CLASH_COURSE_DAYTIME("400", "Course is clash(Days or Time)!"), // �ҵ{�İ�(�P���B�ɶ�)
	CLASH_COURSE("400", "Course is clash!"), // �ҵ{�İ�
	OVER_CREDIT("400", "Credit is over 10!"), // �Ǥ��W�L10
	ALREADY_CHOOSE_COURSE("403", "�w�g��L�ҡA�n�ܰʽЦܥ[�h��!"), // �ҵ{�w�s�b
	
	STUDENT_EXISTED("403", "Student is already exist!"), // �ǥͤw�s�b
	COURSE_IS_EMPTY("400", "�ǥͨèS����Ҹ��!"); // �ǥͨèS����Ҹ��

	private String code;

	private String message;

	private SearchRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
