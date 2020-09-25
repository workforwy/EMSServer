package exception;

/**
 * @author wangyong
 */
public class NameOrPwdErrorException extends Exception{
	//获取异常信息
	@Override
	public String getMessage() {
		return "账号或密码输入错误";
	}
}
