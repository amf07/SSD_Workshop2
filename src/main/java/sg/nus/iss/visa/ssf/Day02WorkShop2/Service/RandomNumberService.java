package sg.nus.iss.visa.ssf.Day02WorkShop2.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

    public List<Integer> generateRanNumbers(int number) {

        return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList());

    }
    
}

