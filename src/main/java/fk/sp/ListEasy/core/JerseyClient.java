package fk.sp.ListEasy.core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientRequest.Builder;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * @author sabarinath.s
 * Date: 06-Jun-2015	
 * Time: 12:40:42 am 
 */

public class JerseyClient {

	private Client client = null;

	private static JerseyClient jc = new JerseyClient();
	private JerseyClient(){
		DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		defaultClientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(defaultClientConfig);

	}

	public static JerseyClient getInstance(){
		return jc;
	}

	public ClientResponse execute(ClientRequest request){
		return client.handle(request);
	}

	public ClientRequest populateRequest(String url, Object payload, Map<String, String> headers, Method m ) throws URISyntaxException{

		Builder entity = ClientRequest.create().entity(payload);

		for(Entry<String, String> e :headers.entrySet())
			entity.header(e.getKey(), e.getValue());
		return entity.build(new URI(url), m.name());
	}

	public static enum Method{
		GET,POST,PUT,DELETE;
	}
}
