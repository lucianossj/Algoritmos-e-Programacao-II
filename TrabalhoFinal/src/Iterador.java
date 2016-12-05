import java.util.Iterator;

public interface Iterador extends Iterator<String> {
	void insertAfter(String dado);
	void insertBefore(String dado);
}