package proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Internet Interface
public interface Internet {
    public void connectTo(String serverhost) throws IOException;

}

//RealInternet
 class RealInternet implements Internet{

    @Override
    public void connectTo(String serverhost) throws IOException {
        System.out.println("Connecting to Server host"+serverhost);
    }
}

//ProxyInternet
class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();
    private static List<String> bannedsites;

    static {
        bannedsites = new ArrayList<String>();
        bannedsites.add("abc.com");
        bannedsites.add("facebook.com");
        bannedsites.add("def.com");
        bannedsites.add("twitter.com");
    }

    @Override
    public void connectTo(String serverhost) throws IOException {
        if(bannedsites.contains(serverhost.toLowerCase()))
        {
            throw new IOException("Access denied");
        }
        internet.connectTo(serverhost);
    }
}

//Client
class Client{
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("youtube.com"); // it will be connected.
            internet.connectTo("facebook.com"); //access denied listed


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}