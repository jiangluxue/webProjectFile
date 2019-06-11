import com.osyunge.utils.FastDFSClient;
import org.junit.Test;

public class testFastDfsClient {
    @Test
    public void testFastDfsClient() throws Exception {
        FastDFSClient client = new FastDFSClient("H:\\ideaProject4\\webProjectFile\\wl-itmuch-manager\\wl-itmuch-manager-web\\src\\main\\resources\\Client.conf");
        String uploadFile = client.uploadFile("C:\\Users\\86198\\Desktop\\毕业设计\\TIM截图20190611004507.png", "png");
        System.out.println(uploadFile);
    }
}
