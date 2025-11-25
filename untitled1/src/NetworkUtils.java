import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkUtils {

    public static String getLocalIP() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // 跳过回环接口和未启用的接口
                if (iface.isLoopback() || !iface.isUp()) continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    // 只返回IPv4地址
                    if (addr.getHostAddress().contains(":")) continue;
                    // 排除127.0.0.1
                    if (addr.getHostAddress().startsWith("127.")) continue;
                    return addr.getHostAddress();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "无法获取IP地址";
    }

    public static void displayAccessInfo() {
        String ip = getLocalIP();
        System.out.println("==========================================");
        System.out.println("您的游戏服务器已启动!");
        System.out.println("本机访问: http://localhost:8080");
        System.out.println("局域网访问: http://" + ip + ":8080");
        System.out.println("==========================================");
    }
}