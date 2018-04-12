package cn.luguangyi.javax.hadoop.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * Created by luguangyi on 2018/4/12.
 */
public class Server {
    public static final String ADDRESS = "localhost";
    public static final int PORT = 9010;
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        //set server ip, port, protocol instance, protocol, handler num
        org.apache.hadoop.ipc.Server server = new RPC.Builder(conf).setBindAddress(ADDRESS)
                .setPort(PORT).setInstance(new ClientProtocolImpl()).setProtocol(ClientProtocol.class)
                .setNumHandlers(5).build();
        server.start();
    }
}
