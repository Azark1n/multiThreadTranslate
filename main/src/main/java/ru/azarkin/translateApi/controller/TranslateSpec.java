package ru.azarkin.translateApi.controller;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import ru.azarkin.translateApi.model.TranslateRequest;

@And({
        @Spec(path = "id", spec = Equal.class),
        @Spec(path = "text", spec = LikeIgnoreCase.class),
        @Spec(path = "from", spec = Equal.class),
        @Spec(path = "to", spec = Equal.class),
})
public interface TranslateSpec extends Specification<TranslateRequest> {
}