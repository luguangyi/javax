package cn.luguangyi.javax.hadoop.rpc;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * Created by luguangyi on 2018/4/12.
 */
public class ClientProtocolImpl implements ClientProtocol {
    public String echo(String value) throws IOException {
        return value;
    }
    public int add(int a, int b) throws IOException {
        return a + b;
    }
    public long getProtocolVersion(String s, long l) throws IOException {
        return ClientProtocol.versionID;
    }
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return new ProtocolSignature(ClientProtocol.versionID, null);
    }
}
