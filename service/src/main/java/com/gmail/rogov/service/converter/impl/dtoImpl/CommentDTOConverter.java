package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Comment;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.CommentDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class CommentDTOConverter implements DTOConverter<Comment, CommentDTO> {
    @Override
    public CommentDTO toDTO(Comment entity) {

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(entity.getId());
        commentDTO.setContent(entity.getContent());
        commentDTO.setCreated(entity.getCreated());
        commentDTO.setUserId(entity.getUser().getId());

        return commentDTO;
    }

    @Override
    public List<CommentDTO> toDTOList(List<Comment> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<CommentDTO> toDTOSet(Set<Comment> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
