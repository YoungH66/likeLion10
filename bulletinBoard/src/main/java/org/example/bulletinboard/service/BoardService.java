package org.example.bulletinboard.service;

import lombok.RequiredArgsConstructor;
import org.example.bulletinboard.domain.Board;
import org.example.bulletinboard.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 전체 게시글 조회
    @Transactional(readOnly = true)
    public Iterable<Board> findAllPosts() {
        return boardRepository.findAll();
    }

    // 특정 게시글 조희, id 기반
    @Transactional(readOnly = true)
    public Board findPostById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시글 등록 & 수정
    @Transactional
    public Board editPost(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    // 페이징 처리된 게시글 목록 조회
    public Page<Board> findAllPosts(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        Pageable sortedByAscId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, "id"));

        return boardRepository.findAll(sortedByDescId);
    }
}
