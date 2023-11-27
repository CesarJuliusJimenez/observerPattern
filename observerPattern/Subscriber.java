package observerPattern;
import java.util.*;
public interface Subscriber {
    public void update(String news);
    public void clientPreference(List<String> preference);
    public void subscribeNews(NewsAgency newsAgency);
    public void unsubscribeNews();
    String clientName();

}
