package com.example.specargresolverdemo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    private lateinit var repo: CustomerRepository;

    @Autowired
    private lateinit var wac: WebApplicationContext;

    private lateinit var mockMvc: MockMvc;

    private lateinit var homer: Customer;
    private lateinit var bart: Customer;

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build()

        homer = repo.save(Customer(name = "Homer"));
        bart = repo.save(Customer(name = "Bart"));
    }

    @Test
    fun shouldFindCustomerByIdAndName() {
        mockMvc.perform(get("/customers")
                .param("id", homer.id.toString())
                .param("name", "Homer"))
                .andExpect(status().isOk())
    }

    @Test
    fun shouldNotFindHomerIfProvidedInvalidId() {
        mockMvc.perform(get("/customers")
                .param("id", "2L")
                .param("name", "Homer"))
                .andExpect(status().isOk())
    }

}