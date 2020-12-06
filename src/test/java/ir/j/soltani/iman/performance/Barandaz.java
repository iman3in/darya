package ir.j.soltani.iman.performance;

import ir.j.soltani.iman.entity.type.GenderType;
import ir.j.soltani.iman.repository.type.GenderTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Barandaz {
    @Autowired
    private GenderTypeRepository genderTypeRepository;

    @Test
    void repositoryPerformance(){
        System.out.println("Test Has Been Started!!!");
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
//            Long tempStart = System.currentTimeMillis();
            genderTypeRepository.save(new GenderType(0L, "Name", "Description"));
            System.out.println(i + "\t" + (System.currentTimeMillis() - start) * 1000D);
//            Long tempEnd = System.currentTimeMillis();
//            System.out.println(i + "\t" + (tempEnd - tempStart) / 1000d);
        }
        Long end = System.currentTimeMillis();
        System.out.println("Test Has Been Ended!!!");
        System.out.println("____________________________________________");
        System.out.println("Total Test Time: " + (end - start) / 1000d);
    }
}
