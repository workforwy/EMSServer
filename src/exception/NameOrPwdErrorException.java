package exception;

/**
 * @author wangyong
 */
public class NameOrPwdErrorException extends Exception{
	//��ȡ�쳣��Ϣ
	@Override
	public String getMessage() {
		return "�˺Ż������������";
	}
}
