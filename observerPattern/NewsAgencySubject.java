package observerPattern;
public interface NewsAgencySubject {
    public void subscribe (Subscriber subscriber);
    public void unsubscribe (Subscriber subscriber);
    public void notification (String news);
}
