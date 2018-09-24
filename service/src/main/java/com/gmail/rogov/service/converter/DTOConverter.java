package com.gmail.rogov.service.converter;

import java.util.List;
import java.util.Set;

public interface DTOConverter<D, E> {

    E toDTO(D entity);

    List<E> toDTOList(List<D> list);

    Set<E> toDTOSet(Set<D> list);

}
