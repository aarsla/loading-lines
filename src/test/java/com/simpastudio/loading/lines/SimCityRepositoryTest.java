package com.simpastudio.loading.lines;

import com.simpastudio.loading.LoaderApplication;
import com.simpastudio.loading.lines.data.model.internal.SimCity;
import com.simpastudio.loading.lines.data.repository.SimCityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoaderApplication.class)
public class SimCityRepositoryTest {

    @Autowired
    private SimCityRepository simCityRepository;

    @Test
    public void whenFindById_thenReturnSimCity() {
        // given
        SimCity message_1 = new SimCity(10001L, "Adding Hidden Agendas");
        simCityRepository.save(message_1);

        // when
        Optional<SimCity> simCity2 = simCityRepository.findById(message_1.getId());

        // then
        assertThat(simCity2.isPresent());
        assertThat(message_1.getMessage()).isEqualTo(simCity2.get().getMessage());
    }

    @Test
    public void whenRandom_thenReturnSimCityList() {
        // given
        SimCity message_1 = new SimCity(10001L, "Adding Hidden Agendas");
        simCityRepository.save(message_1);

        SimCity message_2 = new SimCity(10002L, "Adjusting Bell Curves");
        simCityRepository.save(message_2);

        // when
        List<SimCity> messagesList = simCityRepository.random(2);

        // then
        assertThat(messagesList.size()).isEqualTo(2);
    }
}
