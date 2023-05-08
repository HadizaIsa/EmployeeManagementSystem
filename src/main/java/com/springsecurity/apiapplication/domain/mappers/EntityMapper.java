package com.springsecurity.apiapplication.domain.mappers;

import java.util.List;

public interface EntityMapper<E, D> extends SimpleEntityMapper<E, D>{

    List<D> mapToDtos(List<E> entities);

    List<E> mapToEntites(List<D> dtos);
}
