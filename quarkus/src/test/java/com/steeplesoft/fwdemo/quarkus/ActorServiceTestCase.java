package com.steeplesoft.fwdemo.quarkus;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.steeplesoft.fwdemo.shared.model.Actor;
import com.steeplesoft.fwdemo.quarkus.service.ActorService;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
public class ActorServiceTestCase {
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
