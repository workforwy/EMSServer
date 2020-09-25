package exception;

/**
 * @author wangyong
 */
public class NameAlreadyUseException extends Exception{
	//获取异常信息
	@Override
	public String getMessage() {
		return "账号已存在";
	}
}
