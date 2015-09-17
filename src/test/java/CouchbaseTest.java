import com.couchbase.client.CouchbaseClient;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msaidi on 9/17/15.
 */
public class CouchbaseTest {
    @Test
    public void connect() throws Exception {
        List<URI> uris = new ArrayList<URI>();
        uris.add(new URI("http://127.0.0.1:8091/pool"));
        String bucketName = "default";
        String pwd = "";

        CouchbaseClient couchbaseClient = new CouchbaseClient(uris, bucketName, pwd);
        String key = "article_2015-09-17";
        String value="{\n\"title\":\"couchbase\"\n}";

        couchbaseClient.set(key, value);
        String result = (String) couchbaseClient.get(key);

        Assert.assertEquals(value,result);

    }
}
