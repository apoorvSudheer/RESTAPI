import java.io.IOException;
import static org.junit.Assert.fail;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * GET and POST Request Generic
 */
public class App {
    public String getRequest(String Endpoint) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        System.out.println("URL: " + Endpoint);
        HttpGet httpget = new HttpGet(Endpoint);
        HttpResponse httpresponse;
        int responseCode = 0;
        String jsonString = "";
        try {
            httpresponse = httpclient.execute(httpget);
            responseCode = httpresponse.getStatusLine().getStatusCode();
            System.out.println("Response code from GET API is: " + responseCode);
            jsonString = EntityUtils.toString(httpresponse.getEntity());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            httpclient.close();
        }
        return jsonString;
    }

    public String postRequest(String Endpoint) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        System.out.println("URL: " + Endpoint);
        HttpPost httppost = new HttpPost(Endpoint);
        HttpResponse httpresponse;
        int responseCode = 0;
        String jsonString = "";
        try {
            httpresponse = httpclient.execute(httppost);
            responseCode = httpresponse.getStatusLine().getStatusCode();
            System.out.println("Response code from POST API is: " + responseCode);
            jsonString = EntityUtils.toString(httpresponse.getEntity());
            if(responseCode != 200)
            {
                fail("Resposse code is not 200");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            httpclient.close();
        }
        return jsonString;
    }
}
