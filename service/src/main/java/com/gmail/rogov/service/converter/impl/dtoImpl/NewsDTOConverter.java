package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.News;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.NewsDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class NewsDTOConverter implements DTOConverter<News, NewsDTO> {
    @Override
    public NewsDTO toDTO(News entity) {

        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId(entity.getId());
        newsDTO.setTitle(entity.getTitle());
        newsDTO.setContent(entity.getContent());
        newsDTO.setCreated(entity.getCreated());
        newsDTO.setUserId(entity.getUser().getId());

        return newsDTO;
    }

    @Override
    public List<NewsDTO> toDTOList(List<News> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<NewsDTO> toDTOSet(Set<News> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
