package exception;

/**
 * @author wangyong
 */
public class NameAlreadyUseException extends Exception{
	//��ȡ�쳣��Ϣ
	@Override
	public String getMessage() {
		return "�˺��Ѵ���";
	}
}
