package com.gmail.rogov.service.converter.impl.entityImpl;


import com.gmail.rogov.dao.dao.model.News;
import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.NewsDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class NewsConverter implements Converter<NewsDTO, News> {
    @Override
    public News toEntity(NewsDTO dto) {

        News news = new News();
        User user = new User();

        news.setId(dto.getId());
        news.setTitle(dto.getTitle());
        news.setContent(dto.getContent());
        news.setCreated(dto.getCreated());
        user.setId(dto.getUserId());
        news.setUser(user);


        return news;
    }

    @Override
    public List<News> toEntityList(List<NewsDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<News> toEntitySet(Set<NewsDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
