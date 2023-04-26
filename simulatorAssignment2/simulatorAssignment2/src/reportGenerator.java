import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class reportGenerator {
    private State state;
    reportGenerator(State state){
        this.state = state;
    }
    void setState(State state) {
        this.state = state;
    }
    void request() {
        state.handle();
    }
}
