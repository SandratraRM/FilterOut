package com.workit.filterout;
import org.junit.Ignore;
import org.junit.Test;
import java.net.URL;
public class FilterOutApplicationTest {
    @Test
    @Ignore
    public void main() {
        URL url = this.getClass().getClassLoader().getResource("input.txt");
        if (url == null) throw new RuntimeException("Input file for test is not found");
        String output = "outputResult.txt";
        String[] args = {"-i" , url.getFile(), "-o",output,"words2","words3"};
        FilterOutApplication.main(args);
    }
}