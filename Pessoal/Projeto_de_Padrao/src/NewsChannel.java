public class NewsChannel implements Channel {
    private String nome;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    }

    public void setNews(String news) {

    }
}
