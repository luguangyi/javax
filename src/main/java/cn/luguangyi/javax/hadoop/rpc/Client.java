package cn.luguangyi.javax.hadoop.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by luguangyi on 2018/4/12.
 */
public class Client {

    public static final String ADDRESS = "localhost";
    public static final int PORT = 9010;
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        //server ip and port
        InetSocketAddress inetSocketAddress = new InetSocketAddress(ADDRESS, PORT);
        //get client proxy
        ClientProtocol client = RPC.getProxy(ClientProtocol.class, ClientProtocol.versionID, inetSocketAddress, conf);
        System.out.println(client.add(3, 5));
        System.out.println(client.echo("rpc!"));
    }
}
