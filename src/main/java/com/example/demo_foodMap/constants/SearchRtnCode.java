package com.example.demo_foodMap.constants;

public enum SearchRtnCode {
	VALUE_REQUIRED("400", "Value error(Can not be null or empty)!"), // 不得輸入為 空或是 null
	PRICE_ERROR("400", "Price cannot be null or 0!"), 				 // 輸入價格錯誤
	COMMENT_ERROR("400", "Comment only be allowed 1~5 range!"), 	 // 輸入評價錯誤
	MEALS_EXISTED("403", "餐點已存在!"), 				 			 // 餐點已存在
	STORE_EXISTED("403", "店家已存在!"), 				 			 // 店家已存在
	CREATE_SUCCESSFUL("200", "Created success!"),					 // 創建資料成功
	STORE_NOT_EXISTED("400", "店家不存在，無法創建菜單!"), 			 // 店家並不存在
	DATA_NOT_FOUND("400", "Data is not found!"), 					 // 查無資料
	DATA_IS_FOUND("200", "Data is found!"), 						 // 找到資料
	
	CHOOSE_SUCCESSFUL("200", "Choose success!"), // 創建資料成功
	UPDATE_SUCCESSFUL("200", "Update data success!"), // 修改資料成功
	DELETE_SUCCESSFUL("200", "Delete data success!"), // 刪除資料成功
	
	CHOOSE_FAIL("200", "Choose fail!"), // 創建資料失敗
	DAY_ERROR("400", "Day error!"), // 輸入日期錯誤
	CREDIT_ERROR("400", "Credit error!"), // 輸入學分錯誤
	TIME_ERROR("400", "Time error!"), // 輸入時間錯誤
	
	COURSE_NOT_EXISTED("400", "Course doesn't exist!"), // 此課堂並不存在
	CLASH_COURSE_DAYTIME("400", "Course is clash(Days or Time)!"), // 課程衝堂(星期、時間)
	CLASH_COURSE("400", "Course is clash!"), // 課程衝堂
	OVER_CREDIT("400", "Credit is over 10!"), // 學分超過10
	ALREADY_CHOOSE_COURSE("403", "已經選過課，要變動請至加退選!"), // 課程已存在
	
	STUDENT_EXISTED("403", "Student is already exist!"), // 學生已存在
	COURSE_IS_EMPTY("400", "學生並沒有選課資料!"); // 學生並沒有選課資料

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
