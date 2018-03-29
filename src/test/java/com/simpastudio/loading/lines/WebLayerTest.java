package com.simpastudio.loading.lines;

import com.simpastudio.loading.lines.controller.MessageController;
import com.simpastudio.loading.lines.data.model.Message;
import com.simpastudio.loading.lines.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService service;

    @Test
    public void messageShouldReturnMessageFromService() throws Exception {
        when(service.getMessage()).thenReturn(new Message("Adding Hidden Agendas"));
        this.mockMvc.perform(get("/message")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Adding Hidden Agendas")));
    }
}
