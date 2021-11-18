package mobile.hall;
/**
 * 短信服务接口
 * @author y
 *
 */
public interface SendService{
int sendMessage(int count,MobileCard card)throws Exception;
}
