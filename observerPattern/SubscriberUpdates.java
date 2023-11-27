package observerPattern;
import java.util.*;
public class SubscriberUpdates implements Subscriber {
    private NewsAgency newsAgency;
    private List<String> preferencesList = new ArrayList<>();
    private String user;


    public SubscriberUpdates(String user) {
        this.user = user;
    }

    @Override
    public void update(String news) {
        if (checkPreference(news)) {
            System.out.println(user + " received a breaking news: " + news);
        }
    }

    @Override
    public void clientPreference(List<String> preference) {
        preferencesList = preference;
        System.out.println(user + "'s preferred category is " + preferencesList);
    }

    private boolean checkPreference (String news) {
        for (String preference : preferencesList) {
            if (news.toLowerCase().contains(preference.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void subscribeNews(NewsAgency newsAgency) {
        this.newsAgency = newsAgency;
        newsAgency.subscribe(this);
    }

    @Override
    public void unsubscribeNews() {
        if (newsAgency != null) {
            newsAgency.unsubscribe(this);
        }
    }

    @Override
    public String clientName() {
        return user;
    }

}
