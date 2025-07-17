// package com.api.example.example;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class ExampleApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }

package com.api.example.example;

import com.api.currency.ExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExampleApplication.class)
class ExampleApplicationTests {

    @Test
    void contextLoads() {
    }
}