package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Comment;
import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.CommentDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class CommentConverter implements Converter<CommentDTO, Comment> {
    @Override
    public Comment toEntity(CommentDTO dto) {

        Comment comment = new Comment();
        User user = new User();

        comment.setId(dto.getId());
        comment.setContent(dto.getContent());
        comment.setCreated(dto.getCreated());
        user.setId(dto.getUserId());
        comment.setUser(user);

        return comment;
    }

    @Override
    public List<Comment> toEntityList(List<CommentDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Comment> toEntitySet(Set<CommentDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
