package com.springsecurity.apiapplication.domain.mappers;

public interface SimpleEntityMapper <E, D> {
    D mapToDto(E entity);

    E mapToEntity(D dto);

}
