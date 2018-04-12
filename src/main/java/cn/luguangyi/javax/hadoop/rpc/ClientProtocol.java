package cn.luguangyi.javax.hadoop.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

import java.io.IOException;

/**
 * Created by luguangyi on 2018/4/12.
 */
public interface ClientProtocol extends VersionedProtocol {
    public static final long versionID = 1L;
    String echo(String value) throws IOException;
    int add(int a, int b) throws IOException;
}
