package com.gmail.rogov.service;

import com.gmail.rogov.service.model.CommentDTO;

import java.util.Set;

public interface CommentService {

    CommentDTO create(CommentDTO role);

    CommentDTO update(CommentDTO role);

    CommentDTO delete(CommentDTO role);

    CommentDTO findOne(Long id);

    Set<CommentDTO> findAll();


}
