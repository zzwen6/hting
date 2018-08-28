package top.hting.api;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回定义
 * @author Administrator
 *
 */
@Getter
@Setter
public class ResultAPI {

	private Integer code;
	
	private String msg;
	
	private Object data;
	
	private Object ext;
	
	public static ResultAPI buildSuccess(Object data) {
		return new ResultAPI(0, "成功", data, null);
	}

	public ResultAPI(Integer code, String msg, Object data, Object ext) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.ext = ext;
	}

	public ResultAPI() {
		super();
	}
	
	public static ResultAPI systemError(){
		return new ResultAPI(500, "系统错误", "", "");
	}
	
	
}
