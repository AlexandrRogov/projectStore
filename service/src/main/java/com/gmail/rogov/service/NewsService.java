package com.gmail.rogov.service;

import com.gmail.rogov.service.model.NewsDTO;

import java.util.Set;

public interface NewsService {

    NewsDTO create(NewsDTO role);

    NewsDTO update(NewsDTO role);

    NewsDTO delete(NewsDTO role);

    NewsDTO findOne(Long id);

    Set<NewsDTO> findAll();


}
