package jp.powerbase.test.get;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import jp.powerbase.client.CommandInvoker;
import jp.powerbase.client.Connector;
import jp.powerbase.client.User;
import jp.powerbase.client.command.GetByXQuery;

public class TestGetByXQuery
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			User user = new User("admin", "admin");
			URL server = new URL("http://localhost:8080/powerbase");
			Connector connector = new Connector(user, server);

//			CommandInvoker cmd = new GetByXQuery(connector, "declare namespace pb=\"http://www.powerbase.jp/dtd\"; for $b in doc('/test/bib')/bib/book,$t in $b/title where fn:contains(fn:string($t), \"TCP/IP\") return $b");
			CommandInvoker cmd = new GetByXQuery(connector, "doc('/aozora/sakuhin')//* [text() contains text '芥川']");
			int sc = cmd.request();
			System.out.println("HTTP status code: " + sc);
			InputStream res = cmd.getResponse();
			BufferedReader reader = new BufferedReader(new InputStreamReader(res, "UTF-8"));
			String s = "";
			while ((s = reader.readLine()) != null)
			{
				System.out.println(s);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
