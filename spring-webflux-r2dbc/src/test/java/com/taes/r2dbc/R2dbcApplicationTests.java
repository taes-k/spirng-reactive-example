package com.taes.r2dbc;

import com.taes.r2dbc.entity.ProductMap;
import com.taes.r2dbc.repository.ProductMapRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class R2dbcApplicationTests {

    @Autowired
    private ProductMapRepository productMapRepository;
    private long startTime;
    private long finishTime;
    private long fullProcessTime;
    private long firstChecktime;
    private long firstProcessTime;


    @BeforeEach
    void before() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void after() {
    }

    @Test
    void contextLoads() throws InterruptedException {
        Flux<ProductMap> prods = productMapRepository.getAllProductMap();

        prods.subscribe(
			prod -> {
				if (firstChecktime == 0) firstChecktime = System.currentTimeMillis();
			    }
				, e -> e.printStackTrace()
				, () -> {
			        finishTime = System.currentTimeMillis();

                    finishTime = System.currentTimeMillis();
                    fullProcessTime = finishTime - startTime;
                    firstProcessTime = firstChecktime - startTime;

                    System.out.println("start time : "+startTime);
                    System.out.println("firstCheck time : "+ firstChecktime);
                    System.out.println("finish time : "+finishTime);
                    System.out.println("firstProcess time : "+firstProcessTime);
                    System.out.println("fullProcess time : "+fullProcessTime);
			}
        );

        Thread.sleep(60_000);
    }

}
