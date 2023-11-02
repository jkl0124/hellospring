package hello.core.singleton;

public class SingleTonService {
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance()
    {
        return instance;
    }

    private SingleTonService()
    {

    }
    public void logic()
    {
        System.out.println("싱글톤 로직 객체 호출");
    }
}
