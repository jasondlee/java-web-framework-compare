package com.steeplesoft.fwdemo.quarkus;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.steeplesoft.fwdemo.quarkus.model.Actor;
import com.steeplesoft.fwdemo.quarkus.service.ActorService;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ActorServiceTest {
    @Inject
    protected ActorService actorService;

    @Test
    @Transactional
    public void testGetAll() {
        List<Actor> actors = actorService.findAll();
        Assertions.assertThat(actors).isNotNull();
        Assertions.assertThat(actors).isNotEmpty();
    }
}
